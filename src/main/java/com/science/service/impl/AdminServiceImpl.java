package com.science.service.impl;

import com.science.dto.ParentDTO;
import com.science.dto.StudentRegDTO;
import com.science.dto.StudentUpdateDTO;
import com.science.dto.TeacherDTO;
import com.science.entity.Parent;
import com.science.entity.Student;
import com.science.entity.Teacher;
import com.science.mapper.AdminMapper;
import com.science.mapper.StudentMapper;
import com.science.service.IAdminService;
import com.science.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public void addStudent(StudentRegDTO studentRegDTO) {
        Student student = new Student();
        //将dto类的数据存到entity里面
        student.setUserId(studentRegDTO.getUserId());
        //判断是否该学生已经存在
        Student res = studentMapper.findStudentByUserId(student.getUserId());
        if(res != null){
            throw new StudentDuplicatedException("该学生已经存在");
        }

        student.setStudentName(studentRegDTO.getStudentName());
        student.setSchool(studentRegDTO.getSchool());
        student.setGrade(studentRegDTO.getGrade());
        student.setClasses(studentRegDTO.getClasses());
        student.setCredit(0);   //新学生默认积分为0

        //插入数据库
        Integer rows = adminMapper.insertStudent(student);
        if (rows != 1){
            throw new InsertException("插入数据时产生未知异常");
        }
    }

    @Override
    public void deleteStudent(int id) {
        //先判断该学生是否存在
        Student res = studentMapper.findStudentByUserId(id);
        if (res == null){
            throw new StudentNotFoundException("该学生不存在");
        }

        //删除学生操作
        Integer rows = adminMapper.deleteStudentByUserId(id);
        if(rows != 1){
            throw new DeleteException("删除时产生未知异常");
        }
    }

    @Override
    public void updateStudent(StudentUpdateDTO studentUpdateDTO) {
        //更新之前需要判断该学生是否存在
        Student res = studentMapper.findStudentByUserId(studentUpdateDTO.getUserId());
        if(res == null){
            throw new StudentNotFoundException("该学生不存在");
        }

        Student student = new Student();
        student.setStudentId(studentUpdateDTO.getStudentId());
        student.setUserId(studentUpdateDTO.getUserId());
        student.setStudentName(studentUpdateDTO.getStudentName());
        student.setSchool(studentUpdateDTO.getSchool());
        student.setGrade(studentUpdateDTO.getGrade());
        student.setClasses(studentUpdateDTO.getClasses());
        student.setCredit(studentUpdateDTO.getCredit());

        //更新到数据库
        Integer rows = adminMapper.modifyStudent(student);
        if(rows == 0){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }

    @Override
    public void addTeacher(TeacherDTO teacherDTO) {
        //先判断该教师是否存在
        Integer res = adminMapper.findTeacherById(teacherDTO.getUserId());
        if(res != null){
            throw new TeacherDuplicatedException("该教师已经存在");
        }

        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherDTO.getTeacherId());
        teacher.setUserId(teacherDTO.getUserId());
        teacher.setTeacherName(teacherDTO.getTeacherName());
        teacher.setSchool(teacherDTO.getSchool());
        teacher.setPhone(teacherDTO.getPhone());

        //插入数据库
        Integer rows = adminMapper.insertTeacher(teacher);
        if(rows != 1){
            throw new InsertException("插入数据时产生未知异常");
        }
    }

    @Override
    public void deleteTeacher(int id) {
        //先判断该教师是否存在
        Integer res = adminMapper.findTeacherById(id);
        if (res == null){
            throw new TeacherNotFoundException("该教师不存在");
        }

        //删除教师操作
        Integer rows = adminMapper.deleteTeacherByUserId(id);
        if(rows != 1){
            throw new DeleteException("删除时产生未知异常");
        }
    }

    @Override
    public void updateTeacher(TeacherDTO teacherDTO) {
        //先判断该教师是否存在
        Integer res = adminMapper.findTeacherById(teacherDTO.getUserId());
        if (res == null){
            throw new TeacherNotFoundException("该教师不存在");
        }

        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherDTO.getTeacherId());
        teacher.setUserId(teacherDTO.getUserId());
        teacher.setTeacherName(teacherDTO.getTeacherName());
        teacher.setSchool(teacherDTO.getSchool());
        teacher.setPhone(teacherDTO.getPhone());

        //插入数据库
        Integer rows = adminMapper.modifyTeacher(teacher);
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }

    @Override
    public void addParent(ParentDTO parentDTO) {
        //先判断该家长是否存在
        Integer res = adminMapper.findParentById(parentDTO.getUserId());
        if(res != null){
            throw new ParentDuplicatedException("该家长已经存在");
        }

        Parent parent = new Parent();
        parent.setParentId(parentDTO.getParentId());
        parent.setUserId(parentDTO.getUserId());
        parent.setParentName(parentDTO.getParentName());
        parent.setParentPhone(parentDTO.getParentPhone());

        //插入数据库
        Integer rows = adminMapper.insertParent(parent);
        if(rows != 1){
            throw new InsertException("插入数据时产生未知异常");
        }
    }

    @Override
    public void deleteParent(int id) {
        //先判断该家长是否存在
        Integer res = adminMapper.findParentById(id);
        if(res == null){
            throw new ParentNotFoundException("该家长不存在");
        }

        //删除操作
        Integer rows = adminMapper.deleteParentByUserId(id);
        if(rows != 1){
            throw new DeleteException("删除时产生未知异常");
        }
    }

    @Override
    public void updateParent(ParentDTO parentDTO) {
        //先判断该家长是否存在
        Integer res = adminMapper.findParentById(parentDTO.getUserId());
        if(res == null){
            throw new ParentNotFoundException("该家长不存在");
        }

        Parent parent = new Parent();
        parent.setParentId(parentDTO.getParentId());
        parent.setUserId(parentDTO.getUserId());
        parent.setParentName(parentDTO.getParentName());
        parent.setParentPhone(parentDTO.getParentPhone());

        //更新操作
        Integer rows = adminMapper.modifyParent(parent);
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }
}
