package com.science.service;

import com.science.dto.StudentRegDTO;
import com.science.dto.StudentUpdateDTO;
import com.science.dto.TeacherDTO;

public interface IAdminService {
    public void addStudent(StudentRegDTO studentRegDTO);

    public void deleteStudent(int id);

    public void updateStudent(StudentUpdateDTO studentUpdateDTO);

    public void addTeacher(TeacherDTO teacherDTO);

    public void deleteTeacher(int id);

    public void updateTeacher(TeacherDTO teacherDTO);

}
