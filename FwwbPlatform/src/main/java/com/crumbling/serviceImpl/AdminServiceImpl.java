package com.crumbling.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crumbling.mapper.AdminMapper;
import com.crumbling.domain.LoginUser;
import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.User;
import com.crumbling.enums.HttpEnum;
import com.crumbling.exception.SystemException;
import com.crumbling.service.AdminService;
import com.crumbling.utils.BeanCopyUtils;
import com.crumbling.utils.JwtUtil;
import com.crumbling.utils.RedisCache;
import com.crumbling.vo.LoginVo;
import com.crumbling.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, User> implements AdminService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new SystemException(HttpEnum.LOGIN_ERROR);
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        if(Objects.equals(loginUser.getUser().getAdmin(), "0")){
            throw new SystemException(HttpEnum.ADMINUSER_ERROR);
        }
        String jwt = JwtUtil.createJWT(userId);
        redisCache.setCacheObject("login:"+userId,loginUser);

        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        LoginVo vo = new LoginVo(jwt,userInfoVo);
        return ResponseResult.okResult(vo);
    }

}
