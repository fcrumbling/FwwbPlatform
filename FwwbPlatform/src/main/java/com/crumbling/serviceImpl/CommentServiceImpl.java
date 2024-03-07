package com.crumbling.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crumbling.Mapper.CommentMapper;
import com.crumbling.constants.DomainConstans;
import com.crumbling.domain.Comment;
import com.crumbling.enums.HttpEnum;
import com.crumbling.exception.SystemException;
import com.crumbling.vo.PageVo;
import com.crumbling.domain.ResponseResult;
import com.crumbling.service.CommentService;
import com.crumbling.service.UserService;
import com.crumbling.utils.BeanCopyUtils;
import com.crumbling.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private UserService userService;
    @Override
    public ResponseResult commentList(Long eventId) {
        LambdaQueryWrapper<Comment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Comment::getEventId,eventId);
        lambdaQueryWrapper.eq(Comment::getRootId, DomainConstans.COMMENT_ROOT);
        Page<Comment> page = new Page<>(DomainConstans.COMMENT_STATUS_CURRENT,DomainConstans.COMMENT_STATUS_SIZE);
        page(page,lambdaQueryWrapper);
        List<CommentVo> commentVoList = xxToCommentList(page.getRecords());

        return ResponseResult.okResult(new PageVo(commentVoList,page.getTotal()));
    }

    @Override
    public ResponseResult addComment(Comment comment) {
        if(!StringUtils.hasText(comment.getContent())){
            throw new SystemException(HttpEnum.CONTENT_NOT_NULL);
        }
        save(comment);
        return ResponseResult.okResult();
    }

    private List<CommentVo> xxToCommentList(List<Comment> records) {
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(records, CommentVo.class);
        for (CommentVo commentVo : commentVos) {
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            commentVo.setUsername(nickName);
            if(commentVo.getToCommentUserId() != -1){
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                commentVo.setToCommentUserName(toCommentUserName);
            }
        }
        return commentVos;
    }
}
