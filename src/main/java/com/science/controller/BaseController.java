package com.science.controller;

import com.science.entity.User;
import com.science.service.ex.*;
import com.science.util.JsonResult;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springfox.documentation.spring.web.json.Json;

public class BaseController {
    public static final int OK=200;
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> jsonResult=new JsonResult<Void>(e);
        if(e instanceof InsertException){
            jsonResult.setState(5000);
            jsonResult.setMessage("插入时异常");
        } else if (e instanceof UsernameDuplicatedException) {
            jsonResult.setState(4000);
            jsonResult.setMessage("用户名重复异常");
        } else if (e instanceof JWTCreationException) {
            jsonResult.setState(5001);
            jsonResult.setMessage("生成jwt令牌异常");
        } else if (e instanceof AccountNotFoundException) {
            jsonResult.setState(4001);
            jsonResult.setMessage("用户不存在异常");
        } else if (e instanceof PasswordErrorException) {
            jsonResult.setState(4002);
            jsonResult.setMessage("密码错误异常");
        }
        return jsonResult;
    }
}
