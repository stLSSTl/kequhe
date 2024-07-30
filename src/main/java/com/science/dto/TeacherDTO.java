package com.science.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherDTO implements Serializable {
    private int teacherId;
    private int userId;
    private String teacherName;
    private String school;
    private String phone;
}
