package com.crumbling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crumbling.domain.Event;
import com.crumbling.domain.ResponseResult;
import com.crumbling.dto.AddEventDto;
import com.crumbling.dto.EventDto;

public interface EventService extends IService<Event> {
    ResponseResult eventList(Long type);

    ResponseResult getEventDetail(Long id);

    ResponseResult add(AddEventDto addEventDto);

    ResponseResult delete(Long id);

    ResponseResult edit(EventDto eventDto);

}
