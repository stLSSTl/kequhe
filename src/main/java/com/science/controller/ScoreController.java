package com.science.controller;

import com.science.dto.ScoreDTO;
import com.science.entity.Score;
import com.science.service.IScoreService;
import com.science.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("score")
public class ScoreController extends BaseController{
    @Autowired
    IScoreService iScoreService;

    /**
     * 手动输入学生的成绩信息
     * @param scoreDTO
     * @return
     */
    @PostMapping("add")
    public JsonResult<Void> addScore(@RequestBody ScoreDTO scoreDTO){
        iScoreService.manualAdd(scoreDTO);
        return new JsonResult<Void>(OK);
    }

    /**
     * 文件上传成绩
     * 形式Excel：年级和班级那两栏不能纯数字,需要是字符串类型
     * 成绩编号	学生学号	学生姓名	学校	年级	班级	成绩	考试名称	考试日期
     * 1	2022	张三	zstu	一年级	一班	100	期中考试	2024/8/5
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("upload")
    public JsonResult<Void> addScoreByFile(@RequestParam("file") MultipartFile file) throws IOException {
        iScoreService.uploadScore(file);
        return new JsonResult<Void>(OK);
    }

    /**
     * 更新成绩信息
     * @param scoreDTO
     * @return
     */
    @PutMapping("update")
    public JsonResult<Void> updateScore(@RequestBody ScoreDTO scoreDTO){
        iScoreService.updateScore(scoreDTO);
        return new JsonResult<Void>(OK);
    }

    /**
     * 学生查询自己的成绩，可以筛选成绩、考试名称、考试日期
     * 前端传回学生学号studentId
     * @param id
     * @param score
     * @param examName
     * @param examDate
     * @return
     */
    @GetMapping("studentQuery/{id}")
    public JsonResult<List<Score>> studentQuery(@PathVariable("id") int id,
                                         @RequestParam(value = "score",required=false) Integer score,
                                         @RequestParam("examName") String examName,
                                         @RequestParam("examDate") String examDate){
        if(Objects.equals(examName, "")) examName = null;
        if(Objects.equals(examDate, "")) examDate = null;
        List<Score> scores = iScoreService.studentQuery(id,score,examName,examDate);
        return new JsonResult<List<Score>>(OK,scores);
    }

    /**
     * 老师查询自己班级学生的成绩情况
     * 可以筛选学校、年级、班级、考试名称字段
     * @param id
     * @param grade
     * @param classes
     * @param examName
     * @return
     */
    @GetMapping("teacherQuery/{id}")
    public JsonResult<List<Score>> teacherQuery(@PathVariable("id") int id,
                                                @RequestParam("school") String school,
                                                @RequestParam("grade") String grade,
                                                @RequestParam("classes") String classes,
                                                @RequestParam("examName") String examName){
        if(Objects.equals(school,"")) school = null;
        if(Objects.equals(grade,"")) grade = null;
        if(Objects.equals(classes, "")) classes = null;
        if(Objects.equals(examName, "")) examName = null;
        List<Score> scores = iScoreService.teacherQuery(id,school,grade,classes,examName);
        return new JsonResult<List<Score>>(OK,scores);
    }

    /**
     * 管理员查询所有学生的成绩信息
     * 可通过学生姓名、学校、年级、半径、考试名称、考试日期进行筛选
     * @param studentName
     * @param school
     * @param grade
     * @param classes
     * @param examName
     * @param examDate
     * @return
     */
    @GetMapping("adminQuery")
    public JsonResult<List<Score>> adminQuery(@RequestParam("studentName") String studentName,
                                              @RequestParam("school") String school,
                                              @RequestParam("grade") String grade,
                                              @RequestParam("classes") String classes,
                                              @RequestParam("examName") String examName,
                                              @RequestParam("examDate") String examDate){
        if(Objects.equals(studentName,"")) studentName = null;
        if(Objects.equals(school,"")) school = null;
        if(Objects.equals(grade,"")) grade = null;
        if(Objects.equals(classes, "")) classes = null;
        if(Objects.equals(examName, "")) examName = null;
        if(Objects.equals(examDate, "")) examDate = null;
        List<Score> scores = iScoreService.adminQuery(studentName,school,grade,classes,examName,examDate);
        return new JsonResult<List<Score>>(OK,scores);

    }

}
