package com.science.mapper;

import com.science.entity.Student;
import com.science.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {
    public Integer findByUserId(@Param("userId") int userId);
    public Integer insert(Student student);
}
