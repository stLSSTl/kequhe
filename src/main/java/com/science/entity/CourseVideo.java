package com.science.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseVideo implements Serializable {
    private int videoId;

    private String videoName;

    private int status;

    private Date createTime;

    private String createUser;

    private String coverUrl;

    private String videoUrl;

    private String introduction;
}
