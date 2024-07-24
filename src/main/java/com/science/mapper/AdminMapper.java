package com.science.mapper;

import com.science.entity.CourseVideo;
import com.science.entity.Parent;
import com.science.entity.Student;
import com.science.entity.Teacher;

public interface AdminMapper {
    /**
     * 新增学生
     * @param student
     * @return
     */
    public Integer InsertStudent(Student student);

    /**
     * 根据学生姓名删除学生信息
     * @param name
     * @return
     */
    public Integer DeleteStudentByName(String name);

    /**
     * 修改学生信息
     * @param student
     */
    public void ModifyStudent(Student student);

    /**
     * 新增老师
     * @param teacher
     * @return
     */
    public Integer InsertTeacher(Teacher teacher);

    /**
     * 根据老师姓名删除老师
     * @param name
     * @return
     */
    public Integer DeleteTeacherByName(String name);

    /**
     * 修改老师信息
     * @param teacher
     */
    public void ModifyTeacher(Teacher teacher);

    /**
     * 新增家长
     * @param parent
     * @return
     */
    public Integer InsertParent(Parent parent);

    /**
     * 根据家长姓名删除家长
     * @param name
     * @return
     */
    public Integer DeleteParentByName(String name);

    /**
     * 修改家长信息
     * @param parent
     */
    public void ModifyParent(Parent parent);


}
