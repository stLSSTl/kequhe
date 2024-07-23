package com.science.util;

import com.science.dto.UserLoginDTO;
import lombok.Data;

@Data
public class UserLoginResult {
    private UserLoginDTO userLoginDTO;
    private String jwtToken;

    public UserLoginResult(UserLoginDTO userLoginDTO, String jwtToken) {
        this.userLoginDTO = userLoginDTO;
        this.jwtToken = jwtToken;
    }
}
