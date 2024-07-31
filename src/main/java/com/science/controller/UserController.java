package com.science.controller;

import com.science.dto.UserLoginRequestDTO;
import com.science.dto.UserRegDTO;
import com.science.service.IUserService;
import com.science.util.JsonResult;
import com.science.util.UserLoginResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@Api(tags = "用户管理")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;
    @PostMapping("reg")
    @ApiOperation("注册功能测试")
    public JsonResult<Void> reg(@RequestBody UserRegDTO userRegDTO) {
        //这里如果不加@RequestBody注解就不能通过json数据川籍哪里
        userService.reg(userRegDTO);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("login")
    @ApiOperation("登录功能测试")
    public JsonResult<UserLoginResult> login(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        UserLoginResult userLoginResult = userService.login(userLoginRequestDTO);
        return new JsonResult<>(OK, userLoginResult);
    }
}
