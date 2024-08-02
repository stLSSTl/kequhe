package com.science.service;

import org.springframework.web.multipart.MultipartFile;

public interface IAliOssService {
    public String uploadFile(MultipartFile file);
    public void deleteFile(String videoUrl);
}
