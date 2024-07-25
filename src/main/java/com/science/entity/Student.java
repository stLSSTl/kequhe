package com.science.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private int studentId;
    private int userId;//与User类中的uid对应,uid在users表中为主键，在这里作外键
    private String studentName;
    private String school;
    private String grade;
    private String classes;
    private Integer credit;
}
