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
        //输出异常信息
        authException.printStackTrace();
        //判断是登录出现异常（返回"用户名或密码错误"）
        //还是没有登录就访问接口没有权限（返回"需要登录后访问")
        //其他返回“出现错误”
        ResponseResult result = null;
        if (authException instanceof BadCredentialsException) {
            //用户名密码错误
            //第一个参数返回的是响应码。第二个参数是返回具体的信息
            result = ResponseResult.errorResult(HttpEnum.LOGIN_ERROR.getCode(), authException.getMessage());
        } else if (authException instanceof InsufficientAuthenticationException) {
            //未登录
            //第一个参数返回响应码
            result = ResponseResult.errorResult(HttpEnum.NEED_LOGIN);
        } else {
            //第一个参数返回响应码，第二个参数返回具体信息
            result = ResponseResult.errorResult(HttpEnum.SYSTEM_ERROR.getCode(), "其他错误");
        }
        //使用spring的json工具类将result转为json响应给前端
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
