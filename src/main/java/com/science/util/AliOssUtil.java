package com.science.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.science.service.ex.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.ByteArrayInputStream;

@Component
public class AliOssUtil {
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    /**
     * 文件上传
     *
     * @param bytes      文件内容
     * @param objectName OSS对象名称
     * @return 文件URL
     */
    public String upload(byte[] bytes, String objectName) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(bytes));
        } catch (OSSException | ClientException e) {
            System.err.println("上传文件失败：" + e.getMessage());
            throw new FileUploadException("上传文件失败", e);
        } finally {
            ossClient.shutdown();
        }
        return String.format("https://%s.%s/%s", bucketName, endpoint, objectName);
    }
    public void delete(String videoUrl){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String fileName=extractFileNameFromUrl(videoUrl);
        try {
            ossClient.deleteObject(bucketName,fileName);
        } catch (OSSException | ClientException e) {
            System.err.println("删除文件失败：" + e.getMessage());
            throw new FileUploadException("上传文件失败", e);
        } finally {
            ossClient.shutdown();
        }
    }
    public String extractFileNameFromUrl(String fileUrl){
        int endpointStartIndex = fileUrl.indexOf(endpoint) + endpoint.length() + 1;
        //https://shr1nk-web.oss-cn-hangzhou.aliyuncs.com/f01e549a-624f-49c6-8c3c-c900d5a6d9fe.png
        //比如上面的url aliyun.oss.endpoint=oss-cn-hangzhou.aliyuncs.com
        //那fileUrl.indexOf(endpoint)就是找到endpoint的起始位置 最后加1是因为有'/'
        return fileUrl.substring(endpointStartIndex);
    }
}

