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
    private int uid;//会自动生成不需要输入
    private String username;
    private String password;
    private String salt;//不需要前端输入
    private String userType;
    private Integer isDelete;//不需要前端输入
    private String avatar;
    private String createUser;//不需要前端输入
    private Date createTime;//不需要前端输入

}
