package com.science.mapper;

import com.science.entity.Student;
import com.science.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    public Integer findByUserId(@Param("userId") int userId);
    public Integer insert(Student student);

    public Student findStudentById(@Param("userId") int userId);


    public List<Student> findStudentsByClass(@Param("school") String school, @Param("grade") String grade, @Param("classes") String classes);
}
