package com.crumbling.exception;

import com.crumbling.domain.ResponseResult;
import com.crumbling.enums.HttpEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice

@Slf4j

public class GlobalExceptionHandler {

    @ExceptionHandler(SystemException.class)
    public ResponseResult systemExceptionHandler(SystemException e){

        log.error("出现了异常! {}",e);

        return ResponseResult.errorResult(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e){

        log.error("出现了异常! {}",e);

        return ResponseResult.errorResult(HttpEnum.SYSTEM_ERROR.getCode(),e.getMessage());//枚举值是500
    }
}