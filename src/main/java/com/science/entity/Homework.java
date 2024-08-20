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
public class Homework implements Serializable {
    private int homeworkId;
    private int teacherId;
    private String homeworkName;
    private String content;
    private String picture;
    private String school;
    private String grade;
    private String classes;
    private Date deadline;
}
