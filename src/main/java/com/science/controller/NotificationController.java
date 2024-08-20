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
     * @param teacherId
     * @param title
     * @param content
     * @param grade
     * @param classes
     * @return
     */
    @PostMapping("deliver")
    public JsonResult<Void> deliver(@RequestParam int teacherId,
                                    @RequestParam String title,
                                    @RequestParam String content,
                                    @RequestParam String grade,
                                    @RequestParam String classes) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTeacherId(teacherId);
        notificationDTO.setTitle(title);
        notificationDTO.setContent(content);
        notificationDTO.setGrade(grade);
        notificationDTO.setClasses(classes);

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
