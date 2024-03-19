package com.crumbling.service;

import com.crumbling.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface OSSUploadService {
    ResponseResult eventUpload(MultipartFile img, Long eventid);

    ResponseResult sourceUpload(MultipartFile source, Long achievementid);
}
