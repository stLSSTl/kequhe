package com.science.service;

import com.science.dto.CourseVideoDTO;
import com.science.entity.CourseVideo;
import com.science.entity.VideoCollection;

import java.util.List;

public interface ICourseVideoService {
    public void insertVideo(CourseVideo courseVideo);
    public void deleteVideo(int videoId);
    public CourseVideo findVideoById(int videoId);
    public List<CourseVideo> getVideosByCreateUser(String createUser);
    public CourseVideo convertToEntity(CourseVideoDTO courseVideoDTO);
    public void addCollections(int videoId,int studentId);
    public List<VideoCollection> collectionQuery(int studentId);
    public Void deleteCollection(int videoId,int studentId);
}
