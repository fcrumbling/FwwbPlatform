package com.crumbling.controller;

import com.crumbling.domain.Exhibitor;
import com.crumbling.domain.ResponseResult;
import com.crumbling.service.ExhibitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Exhibitor")
public class ExhibitorController {
    @Autowired
    private ExhibitorService exhibitorService;
    //展商列表
    @GetMapping("/list")
    public ResponseResult exhibitorList(){
        return exhibitorService.exhibitorList();
    }
    //展商详情
    @GetMapping("/{id}")
    public ResponseResult<Exhibitor> getExhibitorById(@PathVariable("id") Long id){
        return exhibitorService.getExhibitorById(id);
    }
}
