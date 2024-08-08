package com.science.service;

import com.science.dto.CorrectHomeworkDTO;
import com.science.dto.HomeworkReleaseDTO;
import com.science.dto.StudentSubmissionDTO;
import com.science.dto.SubmissionUpdateDTO;
import com.science.entity.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IHomeworkService {
    public void insertHomework(HomeworkReleaseDTO homeworkReleaseDTO);
    public void deleteHomework(int id);
    public List<Homework> teacherCheckAll(int id);
    public List<StudentSubmission> teacherCheckOne(int id);
    public void correctHomework(CorrectHomeworkDTO correctHomeworkDTO);
    public void submitHomework(StudentSubmission studentSubmission);
    public void updateSubmissionByStudent(SubmissionUpdateDTO submissionUpdateDTO);
    public List<Homework> studentCheckAll(int studentId);
    public Homework studentCheckOne(int homeworkId);
    public StudentSubmission convertToEntity(StudentSubmissionDTO studentSubmissionDTO);
}
