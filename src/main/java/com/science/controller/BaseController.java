package com.science.controller;

import com.science.entity.User;
import com.science.service.ex.InsertException;
import com.science.service.ex.ServiceException;
import com.science.service.ex.UsernameDuplicatedException;
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
        }
        return jsonResult;
    }
}
