package com.crumbling.handler.security;

import com.alibaba.fastjson.JSON;
import com.crumbling.domain.ResponseResult;
import com.crumbling.enums.HttpEnum;
import com.crumbling.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
//自定义授权失败的处理器
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //输出异常信息
        accessDeniedException.printStackTrace();

        ResponseResult result = ResponseResult.errorResult(HttpEnum.NO_OPERATOR_AUTH);

        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
