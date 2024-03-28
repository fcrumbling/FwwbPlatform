package com.crumbling.handler.security;

import com.alibaba.fastjson.JSON;
import com.crumbling.domain.ResponseResult;
import com.crumbling.enums.HttpEnum;
import com.crumbling.utils.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
//自定义认证失败的处理器
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        authException.printStackTrace();

        ResponseResult result = null;
        if (authException instanceof BadCredentialsException) {

            result = ResponseResult.errorResult(HttpEnum.LOGIN_ERROR.getCode(), authException.getMessage());
        } else if (authException instanceof InsufficientAuthenticationException) {

            result = ResponseResult.errorResult(HttpEnum.NEED_LOGIN);
        } else {
            result = ResponseResult.errorResult(HttpEnum.SYSTEM_ERROR.getCode(), "其他错误");
        }
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
