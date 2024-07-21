package com.science.controller;

import com.science.entity.User;
import com.science.service.IUserService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<Void>(OK);
    }
}
