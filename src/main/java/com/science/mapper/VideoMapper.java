package com.science.mapper;

import com.science.entity.CourseVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VideoMapper {
    public Integer insertVideo(CourseVideo courseVideo);
    public CourseVideo findVideoById(@Param("videoId") int videoId);
    public Integer deleteVideoById(int videoId);

}
