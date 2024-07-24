package com.science.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserLoginDTO implements Serializable {
    private int uid;
    private String username;
    private String password;
    private String avatar;
}
