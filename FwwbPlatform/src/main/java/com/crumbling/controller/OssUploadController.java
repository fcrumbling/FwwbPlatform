package com.crumbling.controller;

import com.crumbling.domain.ResponseResult;
import com.crumbling.service.OSSUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class OssUploadController {
    @Autowired
    private OSSUploadService ossUploadService;
    @PostMapping("/Event/upload")
    public ResponseResult eventUpload(MultipartFile img){
        return ossUploadService.eventUpload(img);
    }
}
