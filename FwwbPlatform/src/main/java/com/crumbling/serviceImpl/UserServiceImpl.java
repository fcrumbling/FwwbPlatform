package com.crumbling.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crumbling.Mapper.UserMapper;
import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.Users;
import com.crumbling.service.UserService;
import com.crumbling.utils.BeanCopyUtils;
import com.crumbling.vo.UserDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseResult getUsersByName(String userName) throws UsernameNotFoundException {
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(userName!=null,Users::getUserName,userName);
        Users users = userMapper.selectOne(wrapper);
        if(users==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        UserDetailVo userDetailVo = BeanCopyUtils.copyBean(users, UserDetailVo.class);
        return ResponseResult.okResult(userDetailVo);
    }
}
