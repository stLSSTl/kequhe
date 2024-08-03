package com.science.mapper;

import com.science.entity.CourseVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {
    public Integer insertVideo(CourseVideo courseVideo);
    public CourseVideo findVideoById(@Param("videoId") int videoId);
    public List<CourseVideo> getVideosByCreateUser(String CreateUser);
    public Integer deleteVideoById(int videoId);

}
