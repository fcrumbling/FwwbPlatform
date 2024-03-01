package com.crumbling.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crumbling.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper extends BaseMapper<User> {
}