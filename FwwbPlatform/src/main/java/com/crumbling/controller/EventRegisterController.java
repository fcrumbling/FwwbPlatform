package com.crumbling.controller;

import com.crumbling.domain.ResponseResult;
import com.crumbling.service.EventRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventregister")
public class EventRegisterController {
    @Autowired
    private EventRegisterService eventRegisterService;
    @PostMapping("/{id}")
    public ResponseResult register(@PathVariable("id") Long eventid ){
        return eventRegisterService.register(eventid);
    }
}
