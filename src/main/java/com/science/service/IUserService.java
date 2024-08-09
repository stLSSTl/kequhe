package com.science.service;

import com.science.dto.UserLoginRequestDTO;
import com.science.dto.UserRegDTO;
import com.science.util.UserLoginResult;

public interface IUserService {
    public void reg(UserRegDTO userRegDTO,String avatar);
    public UserLoginResult login(UserLoginRequestDTO userLoginRequestDTO);
    public String getAvatar(int uid);
    public void changeAvatar(int uid,String avatar);
    public void deleteOldAvatar(String avatar);
}
