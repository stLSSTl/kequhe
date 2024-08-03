package com.science.service;

import com.science.dto.CourseVideoDTO;
import com.science.entity.CourseVideo;

import java.util.List;

public interface ICourseVideoService {
    public void insertVideo(CourseVideo courseVideo);
    public void deleteVideo(int videoId);
    public CourseVideo findVideoById(int videoId);
    public List<CourseVideo> getVideosByCreateUser(String createUser);
    public CourseVideo convertToEntity(CourseVideoDTO courseVideoDTO);
}
