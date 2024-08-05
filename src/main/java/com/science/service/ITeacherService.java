package com.science.service;

import com.science.dto.*;
import com.science.entity.ClassInteraction;
import com.science.entity.SchoolClassInfo;
import com.science.entity.Student;
import com.science.entity.TeacherClass;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ITeacherService {
    public void reg(TeacherRegDTO teacherRegDTO);
    public void addClassesForTeacher(TeacherClassDTO teacherClassDTO);
    public List<Student> getAllStudentByTeacherId(int teacherId);
    public void addInteraction(ClassInteractionDTO classInteractionDTO);
    public void deleteInteraction(int id);

    public void updateInteraction(ClassInteractionDTO classInteractionDTO);
}
