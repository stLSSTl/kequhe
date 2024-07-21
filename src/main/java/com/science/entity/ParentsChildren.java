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
public class ParentsChildren implements Serializable {
    private int id;
    private int parentId;
    private int studentId;
    private String parentName;
    private String childrenName;
}
