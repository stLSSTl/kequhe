package com.science.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Answer {
    private int answerId;
    private int questionId;
    private String content;
    private int userId;
    private String username;
    private Date createTime;
}
