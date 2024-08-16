package com.science.service;

import com.science.dto.NotificationDTO;
import com.science.entity.Notification;

import java.util.List;

public interface INotificationService {
    public void deliver(NotificationDTO notificationDTO);

    public List<Notification> query(int studentId);
}
