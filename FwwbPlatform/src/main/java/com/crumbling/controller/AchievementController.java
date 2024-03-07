package com.crumbling.controller;

import com.crumbling.domain.Achievement;
import com.crumbling.domain.ResponseResult;
import com.crumbling.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Achievement")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @GetMapping("/list")
    public ResponseResult<Achievement> achievementList() {
        return achievementService.achievementList();
    }
}
