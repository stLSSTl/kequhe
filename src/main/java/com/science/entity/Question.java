package com.science.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Question {
    private int questionId;
    private String title;
    private String content;
    private int userId;
    private String username;
    private Date createTime;
}
