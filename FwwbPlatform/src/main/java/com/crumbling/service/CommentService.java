package com.crumbling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crumbling.domain.Comment;
import com.crumbling.domain.ResponseResult;

public interface CommentService extends IService<Comment> {
    ResponseResult commentList(Long eventId);

    ResponseResult addComment(Comment comment);
}
