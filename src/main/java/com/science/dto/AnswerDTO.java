package com.science.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class AnswerDTO {
    private int answerId;
    private int questionId;
    private String content;
    private String username;
    private Date createTime;
    private List<ReplyDTO> replies;
}
