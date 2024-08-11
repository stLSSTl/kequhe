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
public class Feedback implements Serializable {
    private int feedbackId;
    private int userId;
    private UserType userType;
    private String content;
    private Date time;


    public enum UserType{
        student,
        teacher,
        parent
    }
}
