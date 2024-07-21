package com.science.service.impl;

import com.science.entity.User;
import com.science.mapper.UserMapper;
import com.science.service.IUserService;
import com.science.service.ex.InsertException;
import com.science.service.ex.UsernameDuplicatedException;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
        User result=userMapper.findByUsername(user.getUsername());
        if(result!=null){
            throw new UsernameDuplicatedException("用户名重复的异常");
        }
        user.setIsDelete(0);
        user.setCreateUser(user.getUsername());
        user.setCreateTime(new Date());
        Integer rows=userMapper.insert(user);
        if(rows!=1){
            throw new InsertException("插入数据时产生未知异常");
        }
    }
}
