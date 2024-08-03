package com.science.controller;

import com.science.service.ex.*;
import com.science.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    public static final int OK=200;
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> jsonResult=new JsonResult<Void>(e);
        if(e instanceof InsertException){
            jsonResult.setState(5000);
            jsonResult.setMessage("插入时异常");
        } else if (e instanceof JWTCreationException) {
            jsonResult.setState(5001);
            jsonResult.setMessage("生成jwt令牌异常");
        } else if (e instanceof JWTVerificationException) {
            jsonResult.setState(5002);
            jsonResult.setMessage("jwt验证异常");
        }else if (e instanceof DeleteException) {
            jsonResult.setState(5003);
            jsonResult.setMessage("删除时异常");
        }else if (e instanceof UpdateException) {
            jsonResult.setState(5004);
            jsonResult.setMessage("更新信息时的异常");
        }else if (e instanceof UsernameDuplicatedException) {
            jsonResult.setState(4000);
            jsonResult.setMessage("用户名重复异常");
        } else if (e instanceof AccountNotFoundException) {
            jsonResult.setState(4001);
            jsonResult.setMessage("用户不存在异常");
        } else if (e instanceof PasswordErrorException) {
            jsonResult.setState(4002);
            jsonResult.setMessage("密码错误异常");
        } else if (e instanceof UserIdDuplicatedException) {
            jsonResult.setState(4003);
            jsonResult.setMessage("该学生用户信息已完善的异常");
        } else if (e instanceof StudentDuplicatedException) {
            jsonResult.setState(4004);
            jsonResult.setMessage("该学生已存在的异常");
        }else if (e instanceof StudentNotFoundException) {
            jsonResult.setState(4005);
            jsonResult.setMessage("该学生不存在的异常");
        }else if (e instanceof TeacherDuplicatedException) {
            jsonResult.setState(4006);
            jsonResult.setMessage("该教师已存在的异常");
        }else if (e instanceof TeacherNotFoundException) {
            jsonResult.setState(4007);
            jsonResult.setMessage("该教师不存在的异常");
        }else if (e instanceof ParentDuplicatedException) {
            jsonResult.setState(4008);
            jsonResult.setMessage("该家长已存在的异常");
        }else if (e instanceof ParentNotFoundException) {
            jsonResult.setState(4009);
            jsonResult.setMessage("该家长不存在的异常");
        }else if (e instanceof InteractionIdDuplicatedException) {
            jsonResult.setState(4010);
            jsonResult.setMessage("该课堂互动表已经存在的异常");
        }else if (e instanceof InteractionNotFoundException) {
            jsonResult.setState(4011);
            jsonResult.setMessage("该课堂互动表不存在的异常");
        }else if (e instanceof VideoNotFoundException) {
            jsonResult.setState(4013);
            jsonResult.setMessage("视频不存在的异常");
        } else if (e instanceof FileUploadException) {
            jsonResult.setState(4014);
            jsonResult.setMessage("文件上传的异常");
        }else if (e instanceof CreditErrorException) {
            jsonResult.setState(4015);
            jsonResult.setMessage("积分产生未知异常");
        }
        return jsonResult;
    }
}
