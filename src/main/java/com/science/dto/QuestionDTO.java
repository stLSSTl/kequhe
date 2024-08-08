package com.science.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QuestionDTO {
    private int questionId;
    private String title;
    private String content;
    private String username;
    private Date createTime;
    private List<AnswerDTO> answers;
}
