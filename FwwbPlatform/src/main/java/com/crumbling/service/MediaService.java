package com.crumbling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crumbling.domain.MediaContent;
import com.crumbling.domain.ResponseResult;

public interface MediaService extends IService<MediaContent> {
    //分类列表
    ResponseResult MediaList(Long type,Long pageNum,Long pageSize);

    //详情
    ResponseResult GetMediaById(Long id);
}
