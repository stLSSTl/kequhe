package com.science.util;

import com.science.dto.UserLoginResponseDTO;
import lombok.Data;

@Data
public class UserLoginResult {
    private UserLoginResponseDTO userLoginResponseDTO;
    private String jwtToken;
    private int userTypeId;//如果是student对应的就是student表中的studentId,teacher同理

    public UserLoginResult(UserLoginResponseDTO userLoginResponseDTO, String jwtToken,Integer userTypeId) {
        this.userLoginResponseDTO = userLoginResponseDTO;
        this.jwtToken = jwtToken;
        this.userTypeId=userTypeId;
    }
}
