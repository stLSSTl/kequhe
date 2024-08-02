package com.science.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.science.dto.CourseVideoDTO;
import com.science.entity.CourseVideo;
import com.science.mapper.VideoMapper;
import com.science.service.IFileUploadService;
import com.science.service.ex.FileUploadException;
import com.science.util.AliOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements IFileUploadService {
    @Autowired
    private AliOssUtil aliOssUtil;
    public String uploadFile(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            // 生成随机文件名
            String filename = file.getOriginalFilename();
            String fileExtension=filename.substring(filename.lastIndexOf("."));
            String randomFileName = UUID.randomUUID().toString() + fileExtension;

            return aliOssUtil.upload(bytes, randomFileName);
        } catch (IOException e) {
            throw new FileUploadException("文件上传失败: "+e.getMessage());
        }
    }
}
