package com.science.service.impl;

import com.science.dto.ClassInteractionDTO;
import com.science.dto.CourseVideoDTO;
import com.science.dto.TeacherClassDTO;
import com.science.dto.TeacherRegDTO;
import com.science.entity.*;
import com.science.mapper.TeacherMapper;
import com.science.service.ITeacherService;
import com.science.service.ex.*;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public void reg(TeacherRegDTO teacherRegDTO) {
        Teacher teacher=new Teacher();
        teacher.setUserId(teacherRegDTO.getUserId());
        Integer rows=teacherMapper.findTeacherByUserId(teacher.getUserId());
        if(rows!=null){
            throw new UserIdDuplicatedException("该用户已经完善学生信息");//所有角色检查是否完善信息公用的异常
        }
        teacher.setTeacherName(teacherRegDTO.getTeacherName());
        teacher.setSchool(teacherRegDTO.getSchool());
        teacher.setPhone(teacherRegDTO.getPhone());
        teacherMapper.insert(teacher);
    }

    @Override
    public void addClassesForTeacher(TeacherClassDTO teacherClassDTO) {
        TeacherClass teacherClass=new TeacherClass();
        teacherClass.setTeacherId(teacherClassDTO.getTeacherId());
        teacherClass.setTeacherName(teacherClassDTO.getTeacherName());
        teacherClass.setSchool(teacherClassDTO.getSchool());
        teacherClass.setGrade(teacherClassDTO.getGrade());
        teacherClass.setClasses(teacherClassDTO.getClasses());
        teacherClass.setSubject("science");
        Integer rows=teacherMapper.addClassesForTeacher(teacherClass);
        if(rows!=1){
            throw new InsertException("插入时发生未知异常");
        }
    }
    @Override
    public List<Student> getAllStudentByTeacherId(int teacherId) {
        List<SchoolClassInfo> list=teacherMapper.getClassInfoByTeacherId(teacherId);
        List<Student> allStudents=new ArrayList<>();
        for(SchoolClassInfo x:list){
            List<Student> listStudent=teacherMapper.getStudentInfoByClass(x);
            allStudents.addAll(listStudent);
        }
        return allStudents;
    }

    @Override
    public List<SchoolClassInfo> getALLClassByTeacherId(int teacherId) {
        List<SchoolClassInfo> classList=teacherMapper.getClassInfoByTeacherId(teacherId);
        return classList;
    }

    @Override
    public List<Student> getStudentByClassInfo(SchoolClassInfo schoolClassInfo) {
        List<Student> list=teacherMapper.getStudentInfoByClass(schoolClassInfo);
        return list;
    }//从中可以提取出credit

    @Override
    public void addInteraction(ClassInteractionDTO classInteractionDTO) {
        ClassInteraction classInteraction = new ClassInteraction();
        //添加之前需要先检查是否已经存在
        ClassInteraction res= teacherMapper.findInteractionById(classInteractionDTO.getId());
        if(res != null){
            throw  new InteractionIdDuplicatedException("该课堂互动记录已被上传");
        }

        classInteraction.setId(classInteractionDTO.getId());
        classInteraction.setCreateTime(new Date());
        classInteraction.setCreateUser(classInteractionDTO.getCreateUser());
        classInteraction.setTitle(classInteractionDTO.getTitle());
        classInteraction.setContent(classInteractionDTO.getContent());
        classInteraction.setUrl(classInteractionDTO.getUrl());

        //插入数据库
        Integer rows = teacherMapper.insertInteraction(classInteraction);
        if(rows != 1){
            throw new InsertException("插入数据时产生未知异常");
        }
    }



    @Override
    public void deleteInteraction(int id) {
        //删除之前需要查看该课堂互动记录是否存在
        ClassInteraction res = teacherMapper.findInteractionById(id);
        if (res == null){
            throw new InteractionNotFoundException("该互动记录不存在");
        }

        //删除操作
        Integer rows = teacherMapper.deleteInteractionById(id);
        if(rows != 1){
            throw new DeleteException("删除时产生未知异常");
        }
    }

    @Override
    public void updateInteraction(ClassInteractionDTO classInteractionDTO) {
        //更新之前需要查看该课堂互动记录是否存在
        ClassInteraction res = teacherMapper.findInteractionById(classInteractionDTO.getId());
        if (res == null){
            throw new InteractionNotFoundException("该互动记录不存在");
        }

        ClassInteraction classInteraction = new ClassInteraction();
        classInteraction.setId(classInteractionDTO.getId());
        classInteraction.setCreateTime(new Date());
        classInteraction.setCreateUser(classInteractionDTO.getCreateUser());
        classInteraction.setTitle(classInteractionDTO.getTitle());
        classInteraction.setContent(classInteractionDTO.getContent());
        classInteraction.setUrl(classInteractionDTO.getUrl());

        Integer rows = teacherMapper.modifyInteraction(classInteraction);
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }
}
