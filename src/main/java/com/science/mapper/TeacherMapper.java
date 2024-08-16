package com.science.mapper;

import com.science.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
    public Teacher findTeacherByUserId(int UserId);
    public Integer insert(Teacher teacher);
    public Integer addClassesForTeacher(TeacherClass teacherClass);
    public List<SchoolClassInfo> getClassInfoByTeacherId(int teacherId);
    public List<Student> getStudentInfoByClass(SchoolClassInfo schoolClassInfo);



    /**
     * 根据id查找课堂互动表
     * @param id
     * @return
     */
    public ClassInteraction findInteractionById(@Param("id") int id);

    /**
     * 上传课堂互动记录
     * @param classInteraction
     */
    public Integer insertInteraction(ClassInteraction classInteraction);

    /**
     * 老师根据视频名称删除视频
     * @param id
     * @return
     */
    public Integer deleteInteractionById(int id);

    /**
     * 对课堂互动记录进行修改
     * @param classInteraction
     */
    public Integer modifyInteraction(ClassInteraction classInteraction);
}
