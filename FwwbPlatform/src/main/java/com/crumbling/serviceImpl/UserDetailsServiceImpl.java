package com.crumbling.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.crumbling.domain.LoginUser;
import com.crumbling.Mapper.UserMapper;
import com.crumbling.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    //在这里之前，我们已经拿到了登录的用户名和密码。UserDetails是SpringSecurity官方提供的接口
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //根据拿到的用户名，并结合查询条件(数据库是否有这个用户名)，去查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        //判断是否查询到用户，也就是这个用户是否存在，如果没查到就抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户不存在");//后期会对异常进行统一处理
        }

        //TODO 查询权限信息，并封装

        return new LoginUser(user);
    }
}