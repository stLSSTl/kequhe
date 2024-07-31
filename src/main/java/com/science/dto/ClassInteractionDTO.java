package com.science.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClassInteractionDTO implements Serializable {
    private int id;
    private String createUser;
    private String title;
    private String content;
    private String url;
}
