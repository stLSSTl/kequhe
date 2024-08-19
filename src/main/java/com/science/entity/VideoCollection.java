package com.science.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor  //生成一个无参构造函数
@AllArgsConstructor
public class VideoCollection implements Serializable {
    private int id;
    private int videoId;
    private String videoName;
    private String coverUrl;
    private int studentId;
}
