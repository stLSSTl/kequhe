package com.science.mapper;

import com.science.entity.Student;
import com.science.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    public Student findStudentByUserId(@Param("userId") int userId);
    public Student findStudentByStudentId(int studentId);
    public Integer insert(Student student);
    public void updateCredit(int newCredit,int studentId);
    public int getCreditByStudentId(int studentId);
    public List<Student> findStudentsByClass(@Param("school") String school, @Param("grade") String grade, @Param("classes") String classes);
}
