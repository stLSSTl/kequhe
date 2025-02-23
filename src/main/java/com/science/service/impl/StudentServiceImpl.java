package com.science.service.impl;

import com.science.dto.StudentRegDTO;
import com.science.entity.Student;
import com.science.mapper.StudentMapper;
import com.science.service.IStudentService;
import com.science.service.ex.InsertException;
import com.science.service.ex.UserIdDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public void reg(StudentRegDTO studentRegDTO) {
        Student res=studentMapper.findStudentByUserId(studentRegDTO.getUserId());
        if(res!=null){
            throw new UserIdDuplicatedException("该用户已经完善学生信息");
        }
        Student student=convertToEntity(studentRegDTO);
        student.setCredit(0);
        Integer rows=studentMapper.insert(student);
        if(rows!=1){
            throw new InsertException("插入学生时发生异常");
        }
    }

    @Override
    public Student convertToEntity(StudentRegDTO studentRegDTO) {
        Student student=new Student();
        student.setUserId(studentRegDTO.getUserId());
        student.setStudentName(studentRegDTO.getStudentName());
        student.setSchool(studentRegDTO.getSchool());
        student.setGrade(studentRegDTO.getGrade());
        student.setClasses(studentRegDTO.getClasses());
        return student;
    }

}
