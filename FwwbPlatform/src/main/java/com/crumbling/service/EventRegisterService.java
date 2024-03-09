package com.crumbling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.Register;

public interface EventRegisterService extends IService<Register> {
    ResponseResult register(Long eventid);
}
