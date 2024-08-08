package com.science.dto;

import com.science.entity.StudentSubmission;
import lombok.Data;

import java.io.Serializable;

@Data
public class CorrectHomeworkDTO implements Serializable {
    private int submissionId;
    private StudentSubmission.LevelEnum level;
    private String feedback;
}
