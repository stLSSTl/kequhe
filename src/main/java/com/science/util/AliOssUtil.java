package com.science.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
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
            throw new RuntimeException("上传文件失败", e);
        } finally {
            ossClient.shutdown();
        }
        return String.format("https://%s.%s/%s", bucketName, endpoint, objectName);
    }
}