package com.crumbling.serviceImpl;

import com.crumbling.domain.Achievement;
import com.crumbling.domain.Event;
import com.crumbling.domain.ResponseResult;
import com.crumbling.exception.SystemException;
import com.crumbling.service.AchievementService;
import com.crumbling.service.EventService;
import com.crumbling.service.OSSUploadService;
import com.crumbling.enums.HttpEnum;
import com.crumbling.utils.PathUtils;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Data
@Service
@ConfigurationProperties(prefix = "myoss")
public class OSSUploadServiceImpl implements OSSUploadService {
    @Autowired
    private EventService eventService;
    @Override
    public ResponseResult eventUpload(MultipartFile img, Long eventid) {
        String originalFilename = img.getOriginalFilename();
        Long fileSize = img.getSize();
        if (fileSize > 2 * 1024 * 1024) {
            // 抛出文件大小超过限制的异常
            throw new SystemException(HttpEnum.FILE_SIZE_ERROR);
        }

        if(!originalFilename.endsWith(".png") && !originalFilename.endsWith(".jpg")){
            throw new SystemException(HttpEnum.FILE_TYPE_ERROR);
        }
        String filePath = PathUtils.generateFilePath(originalFilename);

        String url = uploadOss(img,filePath);
        Event event = eventService.getById(eventid);
        event.setPictureUrl(url);
        eventService.updateById(event);
        return ResponseResult.okResult(url);
    }
    @Autowired
    private AchievementService achievementService;
    @Override
    public ResponseResult sourceUpload(MultipartFile source, Long achievementid) {
        String originalFilename = source.getOriginalFilename();
        Long fileSize = source.getSize();
        if (fileSize > 10 * 1024 * 1024) {
            // 抛出文件大小超过限制的异常
            throw new SystemException(HttpEnum.FILE_SIZE_ERROR2);
        }

        if(!originalFilename.endsWith(".zip")){
            throw new SystemException(HttpEnum.FILE_TYPE_ERROR2);
        }
        String filePath = PathUtils.generateFilePath(originalFilename);

        String url = uploadOss(source,filePath);
        Achievement achievement = achievementService.getById(achievementid);
        achievement.setSourceUrl(url);
        achievementService.updateById(achievement);
        return ResponseResult.okResult(url);
    }

    //----------------------------------上传文件到七牛云----------------------------------------
    private String xxaccessKey;
    private String xxsecretKey;
    private String xxbucket;

    private String uploadOss(MultipartFile imgFile, String filePath){
        com.qiniu.storage.Configuration cfg = new com.qiniu.storage.Configuration(Region.huadong());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;
        UploadManager uploadManager = new UploadManager(cfg);


        String key = filePath;

        try {

            InputStream xxinputStream = imgFile.getInputStream();

            Auth auth = Auth.create(xxaccessKey, xxsecretKey);
            String upToken = auth.uploadToken(xxbucket);

            try {
                Response response = uploadManager.put(xxinputStream,key,upToken,null, null);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
/*                System.out.println("上传成功! 生成的key是: "+putRet.key);
                System.out.println("上传成功! 生成的hash是: "+putRet.hash);*/
                return "http://sa80c6d6d.hd-bkt.clouddn.com/"+key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        }catch (Exception e) {
            //ignore
        }
        return "上传失败";
    }
}
