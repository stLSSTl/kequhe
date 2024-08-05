package com.science.entity;

import lombok.Data;

@Data
public class TeacherClass {
    private int id;
    private int teacherId;
    private String teacherName;
    private String school;
    private String grade;
    private String classes;
    private String subject;
}
