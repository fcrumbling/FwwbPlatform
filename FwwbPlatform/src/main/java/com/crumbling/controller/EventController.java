package com.crumbling.controller;

import com.crumbling.domain.Event;
import com.crumbling.domain.ResponseResult;
import com.crumbling.dto.AddEventDto;
import com.crumbling.dto.EventDto;
import com.crumbling.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Event")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/list")
    public ResponseResult<Event> EventList(Long type) {
        return eventService.eventList(type);
    }

    @GetMapping("/{id}")
    public ResponseResult getEventDetail(@PathVariable("id") Long id) {
        return eventService.getEventDetail(id);
    }

    @PostMapping("/add")
    public ResponseResult add(@RequestBody AddEventDto addEventDto) {
        return eventService.add(addEventDto);
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Long id) {
        return eventService.delete(id);
    }

    @PutMapping("/edit")
    public ResponseResult edit(@RequestBody EventDto eventDto) {
        return eventService.edit(eventDto);
    }
}
