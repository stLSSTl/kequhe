package com.science.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseVideo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int videoId;

    private String videoName;

    private int status;

    private LocalDateTime createTime;

    private String createUser;

    private String coverUrl;

    private String videoUrl;

    private String introduction;
}
