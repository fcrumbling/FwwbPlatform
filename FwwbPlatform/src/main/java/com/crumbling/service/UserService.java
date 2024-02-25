package com.crumbling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.Users;
public interface UserService extends IService<Users> {
    ResponseResult getUsersByName(String userName);
}
