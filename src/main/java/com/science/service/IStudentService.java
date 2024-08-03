package com.science.service;

import com.science.dto.StudentRegDTO;
import com.science.entity.Student;

public interface IStudentService {
    public void reg(StudentRegDTO studentRegDTO);
    public Student convertToEntity(StudentRegDTO studentRegDTO);
}
