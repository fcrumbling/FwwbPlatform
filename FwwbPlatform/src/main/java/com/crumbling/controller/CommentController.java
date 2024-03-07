package com.crumbling.controller;

import com.crumbling.domain.Comment;
import com.crumbling.service.CommentService;
import com.crumbling.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public ResponseResult commentList(Long eventId){
        return commentService.commentList(eventId);
    }
    @PostMapping
    public ResponseResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
}