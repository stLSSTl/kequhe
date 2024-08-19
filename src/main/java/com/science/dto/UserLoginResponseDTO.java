package com.science.dto;

import lombok.Data;

@Data
public class UserLoginResponseDTO {
    private int uid;
    private String username;
    private String avatar;
    private String userType;
    private String gender;
}
