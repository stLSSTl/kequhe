package com.science.service.impl;

import com.science.dto.CourseVideoDTO;
import com.science.entity.CourseVideo;
import com.science.mapper.VideoMapper;
import com.science.service.IVideoService;
import com.science.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VideoServiceImpl implements IVideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public void insertVideo(CourseVideo courseVideo) {
        Integer rows=videoMapper.insertVideo(courseVideo);
        if(rows!=1){
            throw new InsertException("插入视频时发生异常");
        }
    }

    @Override
    public CourseVideo convertToEntity(CourseVideoDTO courseVideoDTO) {
        CourseVideo courseVideo = new CourseVideo();
        courseVideo.setVideoName(courseVideoDTO.getVideoName());
        courseVideo.setStatus(courseVideoDTO.getStatus());
        courseVideo.setCreateUser(courseVideoDTO.getCreateUser());
        courseVideo.setCoverUrl(courseVideoDTO.getCoverUrl());
        courseVideo.setIntroduction(courseVideoDTO.getIntroduction());
        courseVideo.setCreateTime(new Date());
        return courseVideo;
    }

}
