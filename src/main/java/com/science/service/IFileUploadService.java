package com.science.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadService {
    public String uploadFile(MultipartFile file);
}
