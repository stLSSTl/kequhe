package com.science.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentUpdateDTO implements Serializable {
    private int studentId;
    private int userId;
    private String studentName;
    private String school;
    private String grade;
    private String classes;
    private Integer credit;
}
