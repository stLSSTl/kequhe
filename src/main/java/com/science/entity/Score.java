package com.science.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
public class Score implements Serializable {
    private int scoreId; // 每一条成绩的编号
    private int studentId; // 学生学号，对应student表
    private String studentName; // 学生姓名
    private String school; // 学校
    private String grade; // 年级
    private String classes; // 班级
    private int score; // 成绩
    private String examName; // 考试名称，例如期中考试
    private Date examDate; // 考试日期
}