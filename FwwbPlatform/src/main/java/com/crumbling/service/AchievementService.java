package com.crumbling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crumbling.domain.Achievement;
import com.crumbling.domain.ResponseResult;

public interface AchievementService extends IService<Achievement> {
    //成果列表
    ResponseResult achievementList();
}
