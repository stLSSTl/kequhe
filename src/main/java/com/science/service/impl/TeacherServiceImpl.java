package com.science.service.impl;

import com.science.dto.ClassInteractionDTO;
import com.science.dto.CourseVideoDTO;
import com.science.entity.ClassInteraction;
import com.science.entity.CourseVideo;
import com.science.mapper.TeacherMapper;
import com.science.service.ITeacherService;
import com.science.service.ex.*;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public void addVideo(CourseVideoDTO courseVideoDTO) {
        CourseVideo courseVideo = new CourseVideo();
        //将dto类的数据存到entity里面
        courseVideo.setVideoId(courseVideoDTO.getVideoId());
        //判断是否已存在
        CourseVideo res = teacherMapper.findVideoById(courseVideo.getVideoId());
        if(res != null){
            throw new VideoIdDuplicatedException("该视频已被上传");
        }

        courseVideo.setVideoName(courseVideoDTO.getVideoName());
        courseVideo.setStatus(courseVideoDTO.getStatus());
        courseVideo.setCreateTime(new Date());
        courseVideo.setCreateUser(courseVideoDTO.getCreateUser());
        courseVideo.setCoverUrl(courseVideoDTO.getCoverUrl());
        courseVideo.setVideoUrl(courseVideoDTO.getVideoUrl());
        courseVideo.setIntroduction(courseVideoDTO.getIntroduction());

        //插入数据库
        Integer rows = teacherMapper.insertVideo(courseVideo);
        if (rows != 1){
            throw new InsertException("插入数据时产生未知异常");
        }
    }

    @Override
    public void deleteVideo(int id) {
        //删除视频前需要先判断视频是否存在
        CourseVideo res = teacherMapper.findVideoById(id);
        if (res == null){  //视频不存在
            throw new VideoNotFoundException("该视频不存在");
        }

        //删除视频操作
        Integer rows = teacherMapper.deleteVideoById(id);
        if(rows != 1){
            throw new DeleteException("删除时产生未知异常");
        }
    }


    @Override
    public void updateVideo(CourseVideoDTO courseVideoDTO) {
        //更新视频前需要先判断视频是否存在
        CourseVideo res = teacherMapper.findVideoById(courseVideoDTO.getVideoId());
        if (res == null){  //视频不存在
            throw new VideoNotFoundException("该视频不存在");
        }
        //前端传回的数据里，应该只有视频名称、视频封面、视频状态、视频简介、视频创建者、视频创建时间发生变化
        //视频id，视频内容不能变

        //把DTO里的数据存到entity里面去
        CourseVideo courseVideo = new CourseVideo();
        courseVideo.setVideoId(courseVideoDTO.getVideoId());        //前端传回的数据里面ID应该是不变的，前端页面不应该设置修改id的选项
        courseVideo.setVideoName(courseVideoDTO.getVideoName());    //修改名称
        courseVideo.setStatus(courseVideoDTO.getStatus());          //修改视频状态，是否公开？  前端设置视频状态时，只允许用户设置为0或1
        courseVideo.setCreateTime(new Date());                      //createTime创建时间以最后一次修改的系统时间为准
        courseVideo.setCreateUser(courseVideoDTO.getCreateUser());  //修改创建者
        courseVideo.setCoverUrl(courseVideoDTO.getCoverUrl());      //修改视频封面
        courseVideo.setVideoUrl(courseVideoDTO.getVideoUrl());      //修改视频内容
        courseVideo.setIntroduction(courseVideoDTO.getIntroduction());  //修改视频简介

        //更新视频信息操作
        Integer rows = teacherMapper.modifyVideo(courseVideo);
        if(rows == 0){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }

    @Override
    public void addInteraction(ClassInteractionDTO classInteractionDTO) {
        ClassInteraction classInteraction = new ClassInteraction();
        //添加之前需要先检查是否已经存在
        ClassInteraction res= teacherMapper.findInteractionById(classInteractionDTO.getId());
        if(res != null){
            throw  new InteractionIdDuplicatedException("该课堂互动记录已被上传");
        }

        classInteraction.setId(classInteractionDTO.getId());
        classInteraction.setName(classInteractionDTO.getName());
        classInteraction.setCreateTime(new Date());
        classInteraction.setCreateUser(classInteractionDTO.getCreateUser());
        classInteraction.setTitle(classInteractionDTO.getTitle());
        classInteraction.setContent(classInteractionDTO.getContent());
        classInteraction.setUrl(classInteractionDTO.getUrl());

        //插入数据库
        Integer rows = teacherMapper.insertInteraction(classInteraction);
        if(rows != 1){
            throw new InsertException("插入数据时产生未知异常");
        }
    }

    @Override
    public void deleteInteraction(int id) {
        //删除之前需要查看该课堂互动记录是否存在
        ClassInteraction res = teacherMapper.findInteractionById(id);
        if (res == null){
            throw new InteractionNotFoundException("该互动记录不存在");
        }

        //删除操作
        Integer rows = teacherMapper.deleteInteractionById(id);
        if(rows != 1){
            throw new DeleteException("删除时产生未知异常");
        }
    }

    @Override
    public void updateInteraction(ClassInteractionDTO classInteractionDTO) {
        //更新之前需要查看该课堂互动记录是否存在
        ClassInteraction res = teacherMapper.findInteractionById(classInteractionDTO.getId());
        if (res == null){
            throw new InteractionNotFoundException("该互动记录不存在");
        }

        ClassInteraction classInteraction = new ClassInteraction();
        classInteraction.setId(classInteractionDTO.getId());
        classInteraction.setName(classInteractionDTO.getName());
        classInteraction.setCreateTime(new Date());
        classInteraction.setCreateUser(classInteractionDTO.getCreateUser());
        classInteraction.setTitle(classInteractionDTO.getTitle());
        classInteraction.setContent(classInteractionDTO.getContent());
        classInteraction.setUrl(classInteractionDTO.getUrl());

        Integer rows = teacherMapper.modifyInteraction(classInteraction);
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }
}
