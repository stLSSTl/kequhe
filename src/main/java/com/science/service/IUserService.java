package com.science.service;

import com.science.dto.UserLoginRequestDTO;
import com.science.dto.UserRegDTO;
import com.science.util.UserLoginResult;

public interface IUserService {
    public void reg(UserRegDTO userRegDTO);
    public UserLoginResult login(UserLoginRequestDTO userLoginRequestDTO);
}
