package com.science.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.science.dto.CourseVideoDTO;
import com.science.entity.CourseVideo;
import com.science.service.IAliOssService;
import com.science.service.ICourseVideoService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/videos")
public class VideoController extends BaseController{
    @Autowired
    private IAliOssService aliOssService;
    @Autowired
    private ICourseVideoService courseVideoService;
    @PostMapping("addVideo")
    public JsonResult<CourseVideo> addVideo(@RequestParam String courseVideoDTOJson,
                                     @RequestParam MultipartFile file) throws JsonProcessingException {
        String filePath=aliOssService.uploadFile(file);

        ObjectMapper objectMapper = new ObjectMapper();
        CourseVideoDTO courseVideoDTO = objectMapper.readValue(courseVideoDTOJson, CourseVideoDTO.class);
        CourseVideo courseVideo=courseVideoService.convertToEntity(courseVideoDTO);
        courseVideo.setVideoUrl(filePath);
        courseVideoService.insertVideo(courseVideo);
        return new JsonResult<>(OK,courseVideo);
    }
    @PostMapping("deleteVideo")
    public JsonResult<Void> deleteVideo(int videoId){
        CourseVideo courseVideo=courseVideoService.findVideoById(videoId);
        aliOssService.deleteFile(courseVideo.getVideoUrl());
        courseVideoService.deleteVideo(videoId);
        return new JsonResult<Void>(OK);
    }
}
