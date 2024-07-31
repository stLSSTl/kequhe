package com.science.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParentDTO implements Serializable {
    private int parentId;
    private int userId;
    private String parentName;
    private String parentPhone;
}
