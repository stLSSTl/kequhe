package com.science.service;

import com.science.dto.UserLoginDTO;
import com.science.dto.UserRegDTO;
import com.science.entity.User;
import com.science.util.UserLoginResult;

public interface IUserService {
    public void reg(UserRegDTO userRegDTO);
    public UserLoginResult login(UserLoginDTO userLoginDTO);
}
