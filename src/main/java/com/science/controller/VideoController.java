package com.science.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.science.dto.CourseVideoDTO;
import com.science.entity.CourseVideo;
import com.science.service.IAliOssService;
import com.science.service.ICourseVideoService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController extends BaseController{
    @Autowired
    private IAliOssService aliOssService;
    @Autowired
    private ICourseVideoService courseVideoService;
    /*
    @PostMapping("addVideo")
    public JsonResult<CourseVideo> addVideo(
                                     @RequestParam String courseVideoDTOJson,
                                     @RequestParam MultipartFile videoFile,
                                     @RequestParam MultipartFile coverImage) throws JsonProcessingException {
        String mimeType=videoFile.getContentType();
        String filePath=aliOssService.uploadFile(videoFile,mimeType);
        mimeType=coverImage.getContentType();
        String coverPath=aliOssService.uploadFile(coverImage,mimeType);
        ObjectMapper objectMapper = new ObjectMapper();
        CourseVideoDTO courseVideoDTO = objectMapper.readValue(courseVideoDTOJson, CourseVideoDTO.class);
        CourseVideo courseVideo=courseVideoService.convertToEntity(courseVideoDTO);
        courseVideo.setVideoUrl(filePath);
        courseVideo.setCoverUrl(coverPath);
        courseVideoService.insertVideo(courseVideo);
        return new JsonResult<>(OK,courseVideo);
    }
     */

    @PostMapping("addVideo")
    public JsonResult<CourseVideo> addVideo(
            @RequestParam String videoName,
            @RequestParam Integer status,
            @RequestParam String createUser,
            @RequestParam String introduction,
            @RequestParam MultipartFile videoFile,
            @RequestParam MultipartFile coverImage) {
        String mimeType=videoFile.getContentType();
        String filePath=aliOssService.uploadFile(videoFile,mimeType);
        mimeType=coverImage.getContentType();
        String coverPath=aliOssService.uploadFile(coverImage,mimeType);
        CourseVideo courseVideo=new CourseVideo();
        courseVideo.setVideoName(videoName);
        courseVideo.setStatus(status);
        courseVideo.setCreateUser(createUser);
        courseVideo.setIntroduction(introduction);
        courseVideo.setCreateTime(new Date());
        courseVideo.setVideoUrl(filePath);
        courseVideo.setCoverUrl(coverPath);
        courseVideoService.insertVideo(courseVideo);
        return new JsonResult<>(OK,courseVideo);
    }

    @DeleteMapping("/{videoId}")
    public JsonResult<Void> deleteVideo(@PathVariable int videoId){
        CourseVideo courseVideo=courseVideoService.findVideoById(videoId);
        aliOssService.deleteFile(courseVideo.getVideoUrl());
        aliOssService.deleteFile(courseVideo.getCoverUrl());
        courseVideoService.deleteVideo(videoId);
        return new JsonResult<>(OK);
    }
    @GetMapping("showVideos")
    public JsonResult<List<CourseVideo>> getVideoByCreateUserName(String createUser){
        List<CourseVideo> list=courseVideoService.getVideosByCreateUser(createUser);
        return new JsonResult<>(OK,list);
    }
}
