package com.crumbling.controller;

import com.crumbling.domain.ResponseResult;
import com.crumbling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/userinfo")
    public ResponseResult getUsersByName(@PathVariable("userName") String userName){
        return userService.getUsersByName(userName);
    }
}
