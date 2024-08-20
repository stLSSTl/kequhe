package com.science.mapper;

import com.science.dto.CorrectHomeworkDTO;
import com.science.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeworkMapper {
    public Homework findByHomeworkId(@Param("id") int id);
    public List<Homework> findByTeacherId(@Param("id") int id);

    public List<Homework> findByStudentId(@Param("id") int id);

    public  List<StudentSubmission> findSubmissionByHomeworkId(@Param("id") int id);

    public StudentSubmission findSubmissionBySubmissionId(@Param("id") int id);

    public Integer insertHomework(Homework homework);
    public Integer deleteById(int id);

    public Integer updateByTeacher(CorrectHomeworkDTO correctHomeworkDTO);

    public List<Student> findStudentsByHomeworkId(@Param("homeworkId") int homeworkId);


    public Integer insertSubmission(StudentSubmission studentSubmission);

    public Integer updateSubmissionByStudent(StudentSubmission studentSubmission);

    public Integer updateType1(@Param("submissionId") int submissionId);

    public List<StudentSubmission> findMistakeByStudentId(@Param("studentId") int studentId);

    public Integer updateType0(@Param("submissionId") int submissionId);

    public StudentSubmission findStatusBySubmissionId(@Param("submissionId") int submissionId);
}
