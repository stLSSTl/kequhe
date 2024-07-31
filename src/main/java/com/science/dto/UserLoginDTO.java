package com.science.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserLoginDTO implements Serializable {
    private int uid;
    private String username;
    private String password;//这个参数会在登录验证结束后在业务处理中设为null
    private String avatar;
}
