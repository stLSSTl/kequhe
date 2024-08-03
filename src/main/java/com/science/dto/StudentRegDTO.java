package com.science.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentRegDTO implements Serializable {
    private int userId;
    private String studentName;
    private String school;
    private String grade;
    private String classes;
}
