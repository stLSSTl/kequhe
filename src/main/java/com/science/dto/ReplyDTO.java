package com.science.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ReplyDTO {
    private int replyId;
    private String content;
    private int answerId;
    private String username;
    private Date createTime;
}
