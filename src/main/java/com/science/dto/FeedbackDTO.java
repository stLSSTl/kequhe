package com.science.dto;

import com.science.entity.Feedback;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FeedbackDTO implements Serializable {
    private int feedbackId;
    private int userId;
    private Feedback.UserType userType;
    private String content;
}
