package com.science.mapper;

import com.science.entity.CourseVideo;
import com.science.entity.VideoCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {
    public Integer insertVideo(CourseVideo courseVideo);
    public CourseVideo findVideoById(@Param("videoId") int videoId);
    public List<CourseVideo> getVideosByCreateUser(String CreateUser);
    public Integer deleteVideoById(int videoId);
    public Integer insertCollection(VideoCollection videoCollection);
    public List<VideoCollection> findCollections(@Param("studentId") int studentId);
    public Integer deleteCollection(@Param("videoId") Integer videoId,@Param("studentId") Integer studentId);
}
