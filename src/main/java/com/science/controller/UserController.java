package com.science.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.science.dto.UserLoginRequestDTO;
import com.science.dto.UserRegDTO;
import com.science.service.IAliOssService;
import com.science.service.IUserService;
import com.science.util.JsonResult;
import com.science.util.UserLoginResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("users")
@Api(tags = "用户管理")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IAliOssService aliOssService;
    @PostMapping("reg")
    @ApiOperation("注册功能测试")
    public JsonResult<Void> reg(@RequestParam String userRegDTOJson,
                                @RequestPart MultipartFile avatarFile) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        UserRegDTO userRegDTO=objectMapper.readValue(userRegDTOJson,UserRegDTO.class);
        String mineType=avatarFile.getContentType();
        String avatarPath=aliOssService.uploadFile(avatarFile,mineType);
        //这里如果不加@RequestBody注解就不能通过json数据传进哪里
        userService.reg(userRegDTO,avatarPath);
        return new JsonResult<Void>(OK);
    }
    @PostMapping("login")
    @ApiOperation("登录功能测试")
    public JsonResult<UserLoginResult> login(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        UserLoginResult userLoginResult = userService.login(userLoginRequestDTO);
        return new JsonResult<>(OK, userLoginResult);
    }
    @PostMapping("changeAvatar")
    public JsonResult<Void> changeAvatar(int uid,String oldAvatar,MultipartFile avatarFile){
        userService.deleteOldAvatar(oldAvatar);
        String mineType=avatarFile.getContentType();
        String avatarPath=aliOssService.uploadFile(avatarFile,mineType);
        userService.changeAvatar(uid,avatarPath);
        return new JsonResult<Void>(OK);
    }
}
