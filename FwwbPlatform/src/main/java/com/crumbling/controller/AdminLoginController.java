package com.crumbling.controller;

import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.User;
import com.crumbling.service.AdminService;
import com.crumbling.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminLoginController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return adminService.login(user);
    }
}
