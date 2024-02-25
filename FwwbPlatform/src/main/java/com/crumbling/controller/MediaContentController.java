package com.crumbling.controller;

import com.crumbling.domain.MediaContent;
import com.crumbling.domain.ResponseResult;
import com.crumbling.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Media")
public class MediaContentController {
    @Autowired
    private MediaService mediaService;
    @GetMapping("/list")
    public ResponseResult MediaList(Long type){
        return mediaService.MediaList(type);
    }
    //详情
    @GetMapping("/{id}")
    public ResponseResult<MediaContent> GetMediaById(@PathVariable("id") Long id ){
        return mediaService.GetMediaById(id);
    }
}
