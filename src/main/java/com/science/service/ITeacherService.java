package com.science.service;

import com.science.dto.ClassInteractionDTO;
import com.science.dto.CourseVideoDTO;
import com.science.dto.StudentRegDTO;
import com.science.dto.TeacherRegDTO;
import com.science.entity.ClassInteraction;
import org.springframework.web.multipart.MultipartFile;

public interface ITeacherService {
    public void reg(TeacherRegDTO teacherRegDTO);
    public void addVideo(CourseVideoDTO courseVideoDTO, MultipartFile file);
    public void deleteVideo(int id);
    public void addInteraction(ClassInteractionDTO classInteractionDTO);
    public void deleteInteraction(int id);

    public void updateInteraction(ClassInteractionDTO classInteractionDTO);
}
