package com.crumbling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.User;

public interface AdminService extends IService<User> {
    ResponseResult login(User user);
}
