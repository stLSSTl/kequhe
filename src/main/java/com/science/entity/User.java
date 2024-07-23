package com.science.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor  //生成一个无参构造函数
@AllArgsConstructor
public class User implements Serializable {
    private int uid;
    private String username;
    private String password;
    private String salt;
    private String userType;
    private Integer isDelete;
    private String avatar;
    private String createUser;
    private Date createTime;

}
