package com.crumbling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.crumbling.Mapper")
@SpringBootApplication
public class FwwbPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(FwwbPlatformApplication.class, args);
    }

}
