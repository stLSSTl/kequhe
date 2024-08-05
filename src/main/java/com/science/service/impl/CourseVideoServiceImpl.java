package com.science.service.impl;

import com.science.dto.CourseVideoDTO;
import com.science.entity.CourseVideo;
import com.science.mapper.VideoMapper;
import com.science.service.ICourseVideoService;
import com.science.service.ex.DeleteException;
import com.science.service.ex.InsertException;
import com.science.service.ex.VideoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseVideoServiceImpl implements ICourseVideoService {
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
    public void deleteVideo(int videoId) {
        CourseVideo res = videoMapper.findVideoById(videoId);
        if (res == null){  //视频不存在
            throw new VideoNotFoundException("该视频不存在");
        }
        //删除视频操作
        Integer rows = videoMapper.deleteVideoById(videoId);
        if(rows != 1){
            throw new DeleteException("删除时产生未知异常");
        }
    }

    @Override
    public CourseVideo findVideoById(int videoId) {
        CourseVideo courseVideo=videoMapper.findVideoById(videoId);
        return courseVideo;
    }

    @Override
    public List<CourseVideo> getVideosByCreateUser(String createUser) {
        List<CourseVideo> list=videoMapper.getVideosByCreateUser(createUser);
        return list;
    }

    @Override
    public CourseVideo convertToEntity(CourseVideoDTO courseVideoDTO) {
        CourseVideo courseVideo = new CourseVideo();
        courseVideo.setVideoName(courseVideoDTO.getVideoName());
        courseVideo.setStatus(courseVideoDTO.getStatus());
        courseVideo.setCreateUser(courseVideoDTO.getCreateUser());
        courseVideo.setIntroduction(courseVideoDTO.getIntroduction());
        courseVideo.setCreateTime(new Date());
        return courseVideo;
    }

}
