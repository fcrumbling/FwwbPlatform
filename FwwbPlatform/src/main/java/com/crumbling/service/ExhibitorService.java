package com.crumbling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crumbling.domain.Exhibitor;
import com.crumbling.domain.ResponseResult;

public interface ExhibitorService extends IService<Exhibitor> {
    //id查详情
    ResponseResult getExhibitorById(Long id);
    //展商列表
    ResponseResult exhibitorList();
}
