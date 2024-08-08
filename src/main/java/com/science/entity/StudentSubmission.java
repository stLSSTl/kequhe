package com.science.entity;

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
public class StudentSubmission implements Serializable {
    private int submissionId;
    private int homeworkId;
    private int studentId;
    private String studentName;
    private Date submissionTime;
    private String content;
    private String file;
    private String picture;
    private String sound;
    private SubmissionStatus status;
    private LevelEnum level;
    private String feedback;


    public enum SubmissionStatus{
        corrected,  //已批改
        uncorrected;    //未批改
    }

    public enum LevelEnum{
        A,
        B,
        C,
        D,
        E;
    }
}
