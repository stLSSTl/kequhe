package com.science.controller;

import com.science.dto.NotificationDTO;
import com.science.entity.Notification;
import com.science.service.INotificationService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@RestController
@RequestMapping("notification")
public class NotificationController extends BaseController{
    @Autowired
    INotificationService notificationService;

    /**
     * 教师发布通知
     * @param notificationDTO
     * @return
     */
    @PostMapping("deliver")
    public JsonResult<Void> deliver(@RequestBody NotificationDTO notificationDTO){
        notificationService.deliver(notificationDTO);
        return new JsonResult<Void>(OK);
    }


    /**
     * 学生查看通知
     * @return
     */
    @GetMapping("/studentQuery/{studentId}")
    public JsonResult<List<Notification>> studentQuery(@PathVariable("studentId") int studentId){
        List<Notification> notifications = notificationService.query(studentId);
        return new JsonResult<List<Notification>>(OK,notifications);
    }


}
