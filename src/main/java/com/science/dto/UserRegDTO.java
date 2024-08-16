package com.science.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegDTO implements Serializable{
    private String username;
    private String password;
    private String userType;
    private String gender;
}
