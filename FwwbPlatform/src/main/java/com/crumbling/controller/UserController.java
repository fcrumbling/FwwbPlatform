package com.crumbling.controller;

import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.User;
import com.crumbling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userinfo")
    public ResponseResult getuserInfo() {
        return userService.getuserInfo();
    }

    @PutMapping("/userinfo")
    public ResponseResult updateInfo(@RequestBody User user) {
        return userService.updateInfo(user);
    }

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user) {
        return userService.register(user);
    }
}
