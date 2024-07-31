package com.science.dto;

import lombok.Data;

@Data
public class TeacherRegDTO {
    private int teacherId;
    private int userId;
    private String teacherName;
    private String school;
    private String phone;
}
