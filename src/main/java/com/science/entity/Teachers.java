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
public class Teachers implements Serializable {
    private int teacherId;

    private int userId;

    private String teacherName;

    private String school;

    private String phone;
}
