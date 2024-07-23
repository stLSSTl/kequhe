package com.science.service;

import com.science.dto.UserLoginDTO;
import com.science.dto.UserRegDTO;
import com.science.entity.User;

public interface IUserService {

    public User login(UserLoginDTO userLoginDTO);
    public void reg(UserRegDTO userRegDTO);
}
