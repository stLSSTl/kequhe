package com.science.mapper;

import com.science.entity.Notification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NotificationMapper {

    public Notification findNotificationById(@Param("id") int id);

    public Integer insertNotification(Notification notification);

    public List<Notification> findByStudentId(@Param("studentId") int studentId);
}
