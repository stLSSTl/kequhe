package com.science.controller;

import com.science.dto.UserLoginDTO;
import com.science.dto.UserRegDTO;
import com.science.entity.User;
import com.science.service.IUserService;
import com.science.util.JWTUtil;
import com.science.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users")
@Api(tags = "用户管理")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;
    @Autowired
    private JWTUtil jwtUtil;
    @PostMapping("reg")
    @ApiOperation("注册功能测试")
    public JsonResult<Void> reg(UserRegDTO userRegDTO) {
        userService.reg(userRegDTO);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("login")
    @ApiOperation("登录功能测试")
    public JsonResult<String> login(@RequestBody UserLoginDTO userLoginDTO) {
        User result = userService.login(userLoginDTO);
        // 登录失败，数据库没有找到对应的账号密码
        if (result == null) {
            return new JsonResult<String>(100, "账号或密码错误");
        }
        //登录成功的话，生产JWT令牌
        else {
            String jwtToken=jwtUtil.createToken(userLoginDTO.getUsername());
            return new JsonResult<String>(OK, jwtToken);
        }
    }
}
