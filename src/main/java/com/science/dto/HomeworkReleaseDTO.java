package com.science.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HomeworkReleaseDTO implements Serializable {
    private int homeworkId;
    private int teacherId;
    private String homeworkName;
    private String content;
    private String picture;
    private String file;
    private String school;
    private String grade;
    private String classes;
    private Date deadline;
}
