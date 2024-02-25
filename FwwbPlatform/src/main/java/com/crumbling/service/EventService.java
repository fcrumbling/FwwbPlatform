package com.crumbling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crumbling.domain.Event;
import com.crumbling.domain.ResponseResult;

public interface EventService extends IService<Event> {
    ResponseResult eventList(Long type);
}
