package com.science.service.impl;

import com.science.dto.CorrectHomeworkDTO;
import com.science.dto.HomeworkReleaseDTO;
import com.science.dto.StudentSubmissionDTO;
import com.science.dto.SubmissionUpdateDTO;
import com.science.entity.*;
import com.science.mapper.HomeworkMapper;
import com.science.service.IAliOssService;
import com.science.service.IHomeworkService;
import com.science.service.ex.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class HomeworkServiceImpl implements IHomeworkService {
    @Autowired
    HomeworkMapper homeworkMapper;
    @Autowired
    private IAliOssService aliOssService;

    @Override
    public void insertHomework(HomeworkReleaseDTO homeworkReleaseDTO) {
        Homework homework = new Homework();
        BeanUtils.copyProperties(homeworkReleaseDTO,homework);

        Integer rows = homeworkMapper.insertHomework(homework);
        if(rows != 1)   throw new InsertException("插入数据时出现未知错误");
    }

    @Override
    public void deleteHomework(int id) {
        //先判断传回的作业id是否已经存在
        Homework res = homeworkMapper.findByHomeworkId(id);
        if(res == null) throw new HomeworkNotFoundException("该作业不存在");

        Integer rows = homeworkMapper.deleteById(id);
        if(rows != 1)   throw new DeleteException("删除数据时出现未知错误");
    }

    @Override
    public List<Homework> teacherCheckAll(int id) {
        List<Homework> homeworks = homeworkMapper.findByTeacherId(id);
        if(homeworks.isEmpty()) throw new HomeworkNotFoundException("作业为空");

        return homeworks;
    }

    @Override
    public List<StudentSubmission> teacherCheckOne(int id) {
        List<StudentSubmission> studentSubmissions = homeworkMapper.findSubmissionByHomeworkId(id);
        if(studentSubmissions.isEmpty()) throw new StudentSubmissionNotFoundException("提交记录为空");

        return studentSubmissions;
    }

    @Override
    public void correctHomework(CorrectHomeworkDTO correctHomeworkDTO) {
        //老师是在已经提交的作业中选择一个进行批改，所以不需要判断是否存在

        Integer rows = homeworkMapper.updateByTeacher(correctHomeworkDTO);
        if(rows != 1)   throw new UpdateException("更新数据时出现未知错误");
    }




    @Override
    public void submitHomework(StudentSubmission studentSubmission) {
        //根据提交id判断该提交记录表是否已经存在
        if(homeworkMapper.findSubmissionBySubmissionId(studentSubmission.getSubmissionId())!=null){
            throw new StudentSubmissionIdDuplicatedException("该提交记录已经存在");
        }
        Integer rows = homeworkMapper.insertSubmission(studentSubmission);
        if(rows != 1) throw new InsertException("插入数据时出现未知错误");
    }

    @Override
    public void updateSubmissionByStudent(SubmissionUpdateDTO submissionUpdateDTO) {
        //根据提交id判断该提交记录表是否已经存在
        if(homeworkMapper.findSubmissionBySubmissionId(submissionUpdateDTO.getSubmissionId())==null){
            throw new StudentSubmissionNotFoundException("该提交记录不存在");
        }

        StudentSubmission studentSubmission = new StudentSubmission();
        BeanUtils.copyProperties(submissionUpdateDTO,studentSubmission);
        studentSubmission.setSubmissionTime(new Date());

        Integer rows = homeworkMapper.updateSubmissionByStudent(studentSubmission);
        if(rows != 1) throw new UpdateException("更新数据时出现未知错误");
    }

    @Override
    public List<Homework> studentCheckAll(int studentId) {
        List<Homework> homeworks = homeworkMapper.findByStudentId(studentId);
        if(homeworks.isEmpty()) throw new HomeworkNotFoundException("作业为空");

        return homeworks;
    }

    @Override
    public Homework studentCheckOne(int homeworkId) {
        Homework homework = homeworkMapper.findByHomeworkId(homeworkId);
        if(homework == null) throw new HomeworkNotFoundException("作业为空");

        return homework;
    }

    @Override
    public StudentSubmission convertToEntity(StudentSubmissionDTO studentSubmissionDTO) {
        StudentSubmission studentSubmission = new StudentSubmission();
        studentSubmission.setStudentName(studentSubmissionDTO.getStudentName());
        studentSubmission.setSubmissionTime(new Date());
        studentSubmission.setContent(studentSubmissionDTO.getContent());
        return studentSubmission;
    }

    @Override
    public void addMistake(int submissionId) {
        if(homeworkMapper.findSubmissionBySubmissionId(submissionId)==null){
            throw new StudentSubmissionNotFoundException("该提交记录已存在");
        }
        homeworkMapper.updateType1(submissionId);
    }

    @Override
    public List<StudentSubmission> queryMistake(int studentId) {
        List<StudentSubmission> studentSubmissions = homeworkMapper.findMistakeByStudentId(studentId);
        return studentSubmissions;
    }

    @Override
    public void deleteMistake(int submissionId) {
        if(homeworkMapper.findSubmissionBySubmissionId(submissionId)==null){
            throw new StudentSubmissionNotFoundException("该提交记录不存在");
        }
        homeworkMapper.updateType0(submissionId);
    }

}
