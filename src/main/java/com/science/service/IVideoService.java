package com.science.service;

import com.science.dto.CourseVideoDTO;
import com.science.entity.CourseVideo;

public interface IVideoService {
    public void insertVideo(CourseVideo courseVideo);
    public CourseVideo convertToEntity(CourseVideoDTO courseVideoDTO);
}
