package com.science.service.impl;

import com.science.dto.CourseVideoDTO;
import com.science.entity.CourseVideo;
import com.science.entity.VideoCollection;
import com.science.mapper.VideoMapper;
import com.science.service.ICourseVideoService;
import com.science.service.ex.DeleteException;
import com.science.service.ex.InsertException;
import com.science.service.ex.VideoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void deleteVideo(int videoId) {
        CourseVideo res = videoMapper.findVideoById(videoId);
        if (res == null){  //视频不存在
            throw new VideoNotFoundException("该视频不存在");
        }
        //删除视频操作
        videoMapper.deleteVideoById(videoId);
        //如果该视频被收藏了，删除收藏表里面的数据
        videoMapper.deleteCollection(videoId, null);

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

    @Override
    public void addCollections(int videoId, int studentId) {
        VideoCollection videoCollection = new VideoCollection();
        videoCollection.setVideoId(videoId);
        videoCollection.setVideoName(videoMapper.findVideoById(videoId).getVideoName());
        videoCollection.setCoverUrl(videoMapper.findVideoById(videoId).getCoverUrl());
        videoCollection.setStudentId(studentId);

        Integer rows = videoMapper.insertCollection(videoCollection);
        if(rows!=1){
            throw new InsertException("设置收藏时发生异常");
        }
    }

    @Override
    public List<VideoCollection> collectionQuery(int studentId) {
        List<VideoCollection> videoCollections = videoMapper.findCollections(studentId);
        return videoCollections;
    }

    @Override
    public Void deleteCollection(int videoId,int studentId) {
        Integer rows = videoMapper.deleteCollection(videoId,studentId);
        if(rows != 1)   throw new DeleteException("取消收藏时出现未知错误");
        return null;
    }

}
