package com.crumbling.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crumbling.Mapper.UserMapper;
import com.crumbling.constants.DomainConstans;
import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.User;
import com.crumbling.exception.SystemException;
import com.crumbling.service.UserService;
import com.crumbling.utils.BeanCopyUtils;
import com.crumbling.utils.SecurityUtils;
import com.crumbling.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.crumbling.enums.HttpEnum;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    //--------查询个人信息--------
    @Override
    public ResponseResult getuserInfo() {
        Long id = SecurityUtils.getUserId();
        User user =getById(id);
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        return ResponseResult.okResult(userInfoVo);
    }
    //---------更新个人信息--------
    @Override
    public ResponseResult updateInfo(User user) {
        Long id = SecurityUtils.getUserId();
        user.setId(id);
        updateById(user);
        return ResponseResult.okResult();
    }
    //------------注册-------------
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public ResponseResult register(User user) {
        //对前端传过来的用户名进行非空判断
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(HttpEnum.USERNAME_NOT_NULL);
        }
        //判断密码是否为空
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(HttpEnum.PASSWORD_NOT_NULL);
        }
        //邮箱不能为空
        if (!StringUtils.hasText(user.getEmail())) {
            throw new SystemException(HttpEnum.EMAIL_NOT_NULL);
        }
        //昵称不能为空
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(HttpEnum.NICKNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getPhoneNumber())){
            throw new SystemException(HttpEnum.PHONENUMBER_NOT_NULL);
        }
        //判断用户传入的用户名是否已经在数据库中存在。
        if(userNameExist(user.getUserName())){
            throw new SystemException(HttpEnum.USERNAME_EXIST);
        }
        //判断邮箱
        if(EmailExist(user.getEmail())){
            throw new SystemException(HttpEnum.EMAIL_EXIST);
        }
        if(phonenumberExist(user.getPhoneNumber())){
            throw new SystemException(HttpEnum.PHONENUMBER_EXIST);
        }
        //判断昵称
        if(NickNameExist(user.getNickName())){
            throw new SystemException(HttpEnum.NICKNAME_EXIST);
        }
        //对密码进行加密
        String encodePassword =passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setDelFlag(DomainConstans.SIGN_STATUS);
        user.setAdmin(DomainConstans.SIGN_ADMIN_STATUS);
        //存入数据库
        save(user);
        return ResponseResult.okResult();
    }
    //昵称是否已经存在
    private boolean NickNameExist(String nickName) {
        //去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿来比较
        queryWrapper.eq(User::getNickName,nickName);
        //计数
        boolean result =count(queryWrapper)>0;
        return result;
    }
    //手机号
    private boolean phonenumberExist(String phonenumber) {
        //去数据库查
        LambdaQueryWrapper<User> queryWrapper =new LambdaQueryWrapper<>();
        //拿来比较
        queryWrapper.eq(User::getPhoneNumber,phonenumber);
        //计数
        boolean result =count(queryWrapper)>0;
        return result;
    }

    private boolean EmailExist(String email) {
        //去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿来比较
        queryWrapper.eq(User::getEmail,email);
        //计数
        boolean result =count(queryWrapper)>0;
        return result;
    }
    //用户名是否存在
    private boolean userNameExist(String userName) {
        //去数据库查
        LambdaQueryWrapper<User> queryWrapper =new LambdaQueryWrapper<>();
        //拿来比较
        queryWrapper.eq(User::getUserName,userName);
        //count计数，看看有几条
        boolean result =count(queryWrapper)>0;
        return result;
    }
}
