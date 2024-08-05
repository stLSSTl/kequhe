package com.science.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseVideoDTO implements Serializable {
    private String videoName;
    private Integer status;
    private String createUser;
    private String introduction;
}