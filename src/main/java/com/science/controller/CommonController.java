package com.science.controller;


import com.science.service.ex.FileUploadFailedException;
import com.science.util.AliOssUtil;
import com.science.util.JsonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

import static com.science.controller.BaseController.OK;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    //upload里面的参数file应该与前端传回来的变量名一致
    public JsonResult<String> upload(MultipartFile file){
        log.info("文件上传：{}",file);
        try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名的后缀  .png  .jpg
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //构造新文件名
            String objectName = UUID.randomUUID().toString() + extension;
            //文件的请求路径
            String filePath = aliOssUtil.upload(file.getBytes(), objectName);
            return new JsonResult<>(OK,filePath);
        }catch (IOException e){
            log.error("文件上传失败：{}",e);
        }

        throw new FileUploadFailedException("文件上传失败");
    }
}
