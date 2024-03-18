package com.crumbling;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;

@Component
@SpringBootTest
//@ConfigurationProperties(prefix = "myoss")//指定读取application.yml文件的myoss属性的数据
public class OSSTest {

    private String xxaccessKey;
    private String xxsecretKey;
    private String xxbucket;
    public void setXxaccessKey(String xxaccessKey) {
        this.xxaccessKey = xxaccessKey;
    }
    public void setXxsecretKey(String xxsecretKey) {
        this.xxsecretKey = xxsecretKey;
    }
    public void setXxbucket(String xxbucket) {
        this.xxbucket = xxbucket;
    }

    @Test
    public void testOss(){
        //构造一个带指定 Region 对象的配置类。你的七牛云OSS创建的是哪个区域的，那么就调用Region的什么方法即可
        Configuration cfg = new Configuration(Region.huadong());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
        UploadManager uploadManager = new UploadManager(cfg);

        String key = null;//文件名，null为hash

        try {
            InputStream xxinputStream = new FileInputStream("D:\\资料\\fwwb_platform\\source\\Evant-格致论道.png");

            Auth auth = Auth.create(xxaccessKey, xxsecretKey);
            String upToken = auth.uploadToken(xxbucket);

            try {
                Response response = uploadManager.put(xxinputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println("上传成功! 生成的key是: "+putRet.key);
                System.out.println("上传成功! 生成的hash是: "+putRet.hash);
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
    }
}