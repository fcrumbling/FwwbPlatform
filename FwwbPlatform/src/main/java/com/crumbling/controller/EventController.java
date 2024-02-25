package com.crumbling.controller;

import com.crumbling.domain.Event;
import com.crumbling.domain.ResponseResult;
import com.crumbling.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Event")
public class EventController {
    @Autowired
    private EventService eventService;
    @GetMapping("/list")
    public ResponseResult<Event> EventList(Long type){
        return eventService.eventList(type);
    }
}
