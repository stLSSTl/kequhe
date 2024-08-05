package com.science.service.impl;

import com.science.service.IAliOssService;
import com.science.service.ex.FileUploadException;
import com.science.util.AliOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class AliOssServiceImpl implements IAliOssService {
    @Autowired
    private AliOssUtil aliOssUtil;
    public String uploadFile(MultipartFile file,String mimeType) {
        try {
            byte[] bytes = file.getBytes();
            // 生成随机文件名
            String filename = file.getOriginalFilename();
            String fileExtension=filename.substring(filename.lastIndexOf("."));
            String randomFileName = UUID.randomUUID().toString() + fileExtension;
            return aliOssUtil.upload(bytes,randomFileName,mimeType);
        } catch (IOException e) {
            throw new FileUploadException("文件上传失败: "+e.getMessage());
        }
    }
    public void deleteFile(String videoUrl){
        aliOssUtil.delete(videoUrl);
    }
}
