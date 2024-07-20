package com.science.entity;

import com.science.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor  //生成一个无参构造函数
@AllArgsConstructor
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    private int uid;

    private String username;

    private String password;

    private String salt;

    private UserType userType;

    private int isDelete;

    private String avatar;

    private String createUser;

    private LocalDateTime createTime;

}
