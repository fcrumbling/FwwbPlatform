package com.crumbling.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crumbling.mapper.MediaMapper;
import com.crumbling.domain.MediaContent;
import com.crumbling.domain.ResponseResult;
import com.crumbling.service.MediaService;
import com.crumbling.utils.BeanCopyUtils;
import com.crumbling.vo.MediaListVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MediaServiceImpl extends ServiceImpl<MediaMapper, MediaContent> implements MediaService {
    //------------------列表-------------------
    @Override
    public ResponseResult MediaList(Long type,Long pageNum,Long pageSize) {
        LambdaQueryWrapper<MediaContent> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Objects.nonNull(type)&&type>0,MediaContent::getType,type);
        Page<MediaContent> page = new Page<>(pageNum,pageSize);
        page(page,wrapper);
        List<MediaContent> mediaContentList = page.getRecords();
        List<MediaListVo> mediaListVos = BeanCopyUtils.copyBeanList(mediaContentList, MediaListVo.class);
        return ResponseResult.okResult(mediaListVos);
    }
    //------------------详情-------------------
    @Override
    public ResponseResult GetMediaById(Long id) {
        MediaContent mediaContent = getById(id);
        MediaListVo mediaListVo = BeanCopyUtils.copyBean(mediaContent, MediaListVo.class);
        return ResponseResult.okResult(mediaListVo);
    }
}
