package com.science.util;

import com.science.dto.UserLoginResponseDTO;
import lombok.Data;

@Data
public class UserLoginResult {
    private UserLoginResponseDTO userLoginResponseDTO;
    private String jwtToken;

    public UserLoginResult(UserLoginResponseDTO userLoginResponseDTO, String jwtToken) {
        this.userLoginResponseDTO = userLoginResponseDTO;
        this.jwtToken = jwtToken;
    }
}
