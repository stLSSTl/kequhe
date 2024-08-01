package com.science.service.impl;

import com.science.service.IFileUploadService;
import com.science.service.ex.FileUploadException;
import com.science.util.AliOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadServiceImpl implements IFileUploadService {
    @Autowired
    private AliOssUtil aliOssUtil;

    public String uploadFile(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String objectName = file.getOriginalFilename();
            return aliOssUtil.upload(bytes, objectName);
        } catch (IOException e) {
            throw new FileUploadException("文件上传失败: "+e.getMessage());
        }
    }
}
