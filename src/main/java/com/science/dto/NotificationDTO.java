package com.science.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class NotificationDTO implements Serializable {
    private int id;
    private int teacherId;
    private String title;
    private String content;
    private String grade;
    private String classes;
}
