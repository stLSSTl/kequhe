package com.science.controller;


import com.science.service.IFileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {
    @Autowired
    private IFileUploadService fileUploadService;

}
