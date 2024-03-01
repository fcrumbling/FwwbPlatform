package com.crumbling.service;

import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}