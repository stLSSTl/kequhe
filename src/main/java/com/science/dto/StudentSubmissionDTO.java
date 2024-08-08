package com.science.dto;

import com.science.entity.StudentSubmission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSubmissionDTO implements Serializable {
    private int submissionId;
    private int homeworkId;
    private int studentId;
    private String studentName;
    private String content;
    private String file;
    private String picture;
    private String sound;
}
