package com.science.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.science.dto.FeedbackDTO;
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
    public JsonResult<Void> reg(@RequestParam String username,
                                @RequestParam String password,
                                @RequestParam String userType,
                                @RequestParam MultipartFile avatarFile,
                                @RequestParam String gender) throws JsonProcessingException {
        UserRegDTO userRegDTO=new UserRegDTO();
        userRegDTO.setUsername(username);
        userRegDTO.setPassword(password);
        userRegDTO.setUserType(userType);
        userRegDTO.setGender(gender);
        String mineType=avatarFile.getContentType();
        String avatarPath=aliOssService.uploadFile(avatarFile,mineType);
        userService.reg(userRegDTO,avatarPath);
        return new JsonResult<>(OK);
    }
    @PostMapping("login")
    @ApiOperation("登录功能测试")
    public JsonResult<UserLoginResult> login(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        UserLoginResult userLoginResult = userService.login(userLoginRequestDTO);
        return new JsonResult<>(OK, userLoginResult);
    }
    @PutMapping("avatar/{uid}")
    public JsonResult<Void> changeAvatar(@PathVariable int uid,MultipartFile avatarFile){
        String oldAvatar=userService.getAvatar(uid);
        userService.deleteOldAvatar(oldAvatar);
        String mineType=avatarFile.getContentType();
        String avatarPath=aliOssService.uploadFile(avatarFile,mineType);
        userService.changeAvatar(uid,avatarPath);
        return new JsonResult<>(OK);
    }

    /**
     * 用户反馈
     * @param feedbackDTO
     * @return
     */
    @PostMapping("feedback")
    public JsonResult<Void> submitFeedback(@RequestBody FeedbackDTO feedbackDTO){
        userService.submitFeedback(feedbackDTO);
        return new JsonResult<Void>(OK);
    }
}
