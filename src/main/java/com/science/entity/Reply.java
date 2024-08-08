package com.science.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Reply {
    private int replyId;
    private String content;
    private int answerId;
    private int userId;
    private String username;
    private Date createTime;
}
