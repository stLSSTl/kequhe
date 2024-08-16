package com.science.controller;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.science.dto.CorrectHomeworkDTO;
import com.science.dto.HomeworkReleaseDTO;
import com.science.dto.StudentSubmissionDTO;
import com.science.dto.SubmissionUpdateDTO;
import com.science.entity.Homework;
import com.science.entity.StudentSubmission;
import com.science.service.IAliOssService;
import com.science.service.IHomeworkService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("homework")
public class HomeworkController extends BaseController{
    @Autowired
    IHomeworkService iHomeworkService;
    @Autowired
    private IAliOssService aliOssService;

    /**
     * 老师发布作业
     * @param homeworkReleaseDTO
     * @return
     */
    @PostMapping("release")
    public JsonResult<Void> releaseHomework(@RequestBody HomeworkReleaseDTO homeworkReleaseDTO){
        iHomeworkService.insertHomework(homeworkReleaseDTO);
        return new JsonResult<>(OK);
    }

    /**
     * 老师根据作业id删除作业
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public JsonResult<Void> deleteHomework(@PathVariable("id") int id){
        iHomeworkService.deleteHomework(id);
        return new JsonResult<Void>(OK);
    }

    /**
     * 根据老师id，查看该老师布置的所有作业
     * 例如，老师点开“我的作业”页面，会显示自己布置的作业
     * @param id
     * @return
     */
    @GetMapping("teacherCheckAll/{id}")
    public JsonResult<List<Homework>> teacherCheckAll(@PathVariable("id") int id){
        List<Homework> homeworks = iHomeworkService.teacherCheckAll(id);
        return new JsonResult<List<Homework>>(OK,homeworks);
    }


    /**
     * 老师根据作业id查看具体某个作业的完成情况
     * 返回前端的是学生的提交信息
     * 老师在“我的作业”页面选择任一自己布置的作业，点击查看完成情况
     * 因此就不需要teacherId了，因为在“我的页面”里面显示的都是该老师布置的作业
     * @param id
     * @return
     */
    @GetMapping("teacherCheckOne/{id}")
    public JsonResult<List<StudentSubmission>> teacherCheckOne(@PathVariable("id") int id){
        List<StudentSubmission> studentSubmissions = iHomeworkService.teacherCheckOne(id);
        return new JsonResult<List<StudentSubmission>>(OK,studentSubmissions);
    }

    /**
     * 老师根据提交的id批改作业
     * @param correctHomeworkDTO
     * @return
     */
    @PutMapping("correct")
    public JsonResult<Void> correctHomework(@RequestBody CorrectHomeworkDTO correctHomeworkDTO){
        iHomeworkService.correctHomework(correctHomeworkDTO);
        return new JsonResult<Void>(OK);
    }



    /**
     * 学生提交作业
     * @param studentSubmissionDTOJson
     * @param file
     * @param picture
     * @param sound
     * @return
     * @throws JsonProcessingException
     */
    @PostMapping("submit")
    public JsonResult<Void> submitHomework(@RequestParam  String studentSubmissionDTOJson,
                                           @RequestParam MultipartFile file,
                                           @RequestParam MultipartFile picture,
                                           @RequestParam MultipartFile sound)throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        StudentSubmissionDTO studentSubmissionDTO = objectMapper.readValue(studentSubmissionDTOJson,StudentSubmissionDTO.class);
        StudentSubmission studentSubmission = iHomeworkService.convertToEntity(studentSubmissionDTO);

        String mimeType,filePath,picturePath,soundPath;
        if (file != null && !StringUtils.isEmpty(file.getOriginalFilename()) && !StringUtils.isEmpty(file.getContentType())) {
            mimeType = file.getContentType();
            filePath = aliOssService.uploadFile(file, mimeType);
            studentSubmission.setFile(filePath);
        }

        if(picture != null && !StringUtils.isEmpty(picture.getOriginalFilename()) && !StringUtils.isEmpty(picture.getContentType())) {
            mimeType = picture.getContentType();
            picturePath = aliOssService.uploadFile(picture, mimeType);
            studentSubmission.setPicture(picturePath);
        }

        if(sound != null && !StringUtils.isEmpty(sound.getOriginalFilename()) && !StringUtils.isEmpty(sound.getContentType())) {
            mimeType = sound.getContentType();
            soundPath = aliOssService.uploadFile(sound, mimeType);
            studentSubmission.setSound(soundPath);
        }

        iHomeworkService.submitHomework(studentSubmission);
        return new JsonResult<Void>(OK);
    }



    /**
     * 学生修改提交的作业
     * @param submissionUpdateDTO
     * @return
     */
    @PutMapping("updateSubmission")
    public JsonResult<Void> updateSubmissionByStudent(@RequestBody SubmissionUpdateDTO submissionUpdateDTO){
        iHomeworkService.updateSubmissionByStudent(submissionUpdateDTO);
        return new JsonResult<Void>(OK);
    }

    /**
     * 学生查看自己的作业，场景：学生点开“我的作业”，里面会显示自己有哪些作业
     * @param studentId
     * @return
     */
    @GetMapping("studentCheckAll/{studentId}")
    public JsonResult<List<Homework>> studentCheckAll(@PathVariable("studentId") int studentId){
        List<Homework> homeworks = iHomeworkService.studentCheckAll(studentId);
        return new JsonResult<List<Homework>>(OK,homeworks);
    }


    /**
     * 学生查看自己具体某一个作业，场景：学生在“我的作业”页面，任意点开一个自己的作业
     * @param homeworkId
     * @return
     */
    @GetMapping("studentCheckOne/{homeworkId}")
    public JsonResult<Homework> StudentCheckOne(@PathVariable("homeworkId") int homeworkId){
        Homework homework = iHomeworkService.studentCheckOne(homeworkId);
        return new JsonResult<Homework>(OK,homework);
    }

}
