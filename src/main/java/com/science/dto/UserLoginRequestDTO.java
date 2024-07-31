package com.science.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserLoginRequestDTO implements Serializable {
    private String username;
    private String password;
}
