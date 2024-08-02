package com.science.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.science.dto.CourseVideoDTO;
import com.science.entity.CourseVideo;
import com.science.service.IFileUploadService;
import com.science.service.IVideoService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@RequestMapping("/videos")
public class VideoController extends BaseController{
    @Autowired
    private IFileUploadService fileUploadService;
    @Autowired
    private IVideoService videoService;
    @PostMapping("addVideo")
    public JsonResult<CourseVideo> addVideo(@RequestParam String courseVideoDTOJson,
                                     @RequestParam MultipartFile file) throws JsonProcessingException {
        String filePath=fileUploadService.uploadFile(file);

        ObjectMapper objectMapper = new ObjectMapper();
        CourseVideoDTO courseVideoDTO = objectMapper.readValue(courseVideoDTOJson, CourseVideoDTO.class);
        CourseVideo courseVideo=videoService.convertToEntity(courseVideoDTO);
        courseVideo.setVideoUrl(filePath);
        videoService.insertVideo(courseVideo);
        return new JsonResult<>(OK,courseVideo);
    }
}
