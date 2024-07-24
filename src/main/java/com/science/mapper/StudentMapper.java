package com.science.mapper;

import com.science.entity.Student;
import com.science.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    public Integer insert(Student student);
}
