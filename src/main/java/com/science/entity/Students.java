package com.science.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Students implements Serializable {
    private int studentId;

    private int userId;

    private String studentName;

    private String school;

    private String grade;

    private String classes;

    private int credit;
}
