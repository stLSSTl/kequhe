package com.science.controller;

import com.science.controller.ex.AIPainterException;
import com.science.service.ex.*;
import com.science.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    public static final int OK=200;
    @ExceptionHandler({ServiceException.class,AIPainterException.class})
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
        } else if (e instanceof ScoreNumberError) {
            jsonResult.setState(4016);
            jsonResult.setMessage("成绩不在0-100之间的异常");
        } else if (e instanceof ScoreRecordNotFoundException) {
            jsonResult.setState(4017);
            jsonResult.setMessage("该成绩记录不存在的异常");
        } else if (e instanceof ScoreIdDuplicatedException) {
            jsonResult.setState(4018);
            jsonResult.setMessage("该成绩记录已存在的异常");
        } else if (e instanceof HomeworkIdDuplicatedException) {
            jsonResult.setState(4019);
            jsonResult.setMessage("该作业已经存在的异常");
        } else if (e instanceof HomeworkNotFoundException) {
            jsonResult.setState(4020);
            jsonResult.setMessage("该作业不存在的异常");
        } else if (e instanceof StudentSubmissionNotFoundException) {
            jsonResult.setState(4021);
            jsonResult.setMessage("提交记录不存在的异常");
        } else if (e instanceof StudentSubmissionIdDuplicatedException) {
            jsonResult.setState(4022);
            jsonResult.setMessage("提交记录已经存在的异常");
        } else if (e instanceof AIPainterException) {
            jsonResult.setState(5005);//宽泛异常暂时用5xxx跟具体异常4xxx区分
            jsonResult.setMessage("AI绘图发生未知异常");
        } else if (e instanceof SpeechToTextException) {
            jsonResult.setState(5006);
            jsonResult.setMessage("语音识别发生未知异常");
        } else if (e instanceof AIAnswerServiceException) {
            jsonResult.setState(5007);
            jsonResult.setMessage("AI回复发生未知异常");
        } else if (e instanceof UserNotFoundException) {
            jsonResult.setState(4016);
            jsonResult.setMessage("用户不存在异常");
        }
        return jsonResult;
    }
}
