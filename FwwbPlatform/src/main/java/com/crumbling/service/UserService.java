package com.crumbling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.User;

public interface UserService extends IService<User> {
    ResponseResult getuserInfo();

    ResponseResult updateInfo(User user);

    ResponseResult register(User user);
}
