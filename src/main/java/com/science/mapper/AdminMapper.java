package com.science.mapper;

import com.science.entity.Student;
import com.science.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    /**
     * 新增学生
     * @param student
     * @return
     */
    public Integer insertStudent(Student student);

    /**
     * 根据学生姓名删除学生信息
     * @param id
     * @return
     */
    public Integer deleteStudentByUserId(int id);

    /**
     * 修改学生信息
     * @param student
     */
    public Integer modifyStudent(Student student);

    /**
     * 根据userId查找老师
     * @param userId
     * @return
     */
    public Integer findTeacherById(@Param("userId") int userId);

    /**
     * 新增老师
     * @param teacher
     * @return
     */
    public Integer insertTeacher(Teacher teacher);

    /**
     * 根据老师姓名删除老师
     * @param id
     * @return
     */
    public Integer deleteTeacherByUserId(int id);

    /**
     * 修改老师信息
     * @param teacher
     */
    public Integer modifyTeacher(Teacher teacher);



}
