package com.crumbling.controller;

import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.User;
import com.crumbling.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    //--------登录--------
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }
    //--------登出---------
    @PostMapping("/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
