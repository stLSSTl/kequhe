package com.science.service.impl;

import com.science.dto.NotificationDTO;
import com.science.entity.Notification;
import com.science.mapper.NotificationMapper;
import com.science.service.INotificationService;
import com.science.service.ex.InsertException;
import com.science.service.ex.NotificationIdDuplicatedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NotificationServiceImpl implements INotificationService {
    @Autowired
    NotificationMapper notificationMapper;

    @Override
    public void deliver(NotificationDTO notificationDTO) {
        //先根据id判断是否已经存在
        Notification res = notificationMapper.findNotificationById(notificationDTO.getId());
        if(res != null)     throw new NotificationIdDuplicatedException("通知不存在");

        Notification notification = new Notification();
        BeanUtils.copyProperties(notificationDTO,notification);
        notification.setTime(new Date());

        //插入数据库
        Integer rows = notificationMapper.insertNotification(notification);
        if(rows != 1) throw new InsertException("插入数据时出现异常");
    }

    @Override
    public List<Notification> query(int studentId) {
        List<Notification> notifications = notificationMapper.findByStudentId(studentId);
        return notifications;
    }
}
