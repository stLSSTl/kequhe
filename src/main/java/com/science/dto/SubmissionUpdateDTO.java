package com.science.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubmissionUpdateDTO implements Serializable {
    private int submissionId;
    private String content;
    private String file;
    private String picture;
    private String sound;
}
