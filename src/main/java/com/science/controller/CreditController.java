package com.science.controller;

import com.science.entity.Student;
import com.science.util.JsonResult;
import com.science.service.ICreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("credit")
@Slf4j
public class CreditController extends BaseController{
    @Autowired
    ICreditService creditService;

    @PostMapping("addCredit")
    public JsonResult<Integer> addCredit(int studentId,int point){
        int newCredit=creditService.addPoints(studentId,point);
        return new JsonResult<>(OK,newCredit);
    }

    /**
     * 判断并返回学生的称号
     * 前端传回学生的userId，后端返回该学生的称号
     * @param id
     * @return
     */
    @GetMapping("studentTitle/{id}")
    public JsonResult<String> getStudentTitle(@PathVariable("id") int id){
        String title = creditService.getTitleByCredit(id);
        return new JsonResult<String>(OK,title);
    }


    /**
     * 根据学校年级班级返回该班级的学生积分排行榜（降序）
     * @param grade
     * @param classes
     * @return
     */
    @GetMapping("ranking")
    public JsonResult<List<Student>> getCreditRankingByClass(@RequestParam("school") String school,
                                                             @RequestParam("grade") String grade,
                                                             @RequestParam("classes") String classes){
        //如果用户筛选的时候没有选择school，那默认school传到后端是就是空字符串，将其转换成null，便于xml文件中的SQL语句执行
        if(Objects.equals(school,"")) school = null;
        if(Objects.equals(grade, "")) grade = null;
        if(Objects.equals(classes, "")) classes = null;
        List<Student> students = creditService.getCreditByClass(school,grade,classes);
        return new JsonResult<>(OK,students);
    }

    /**
     * 根据userId传回具体学生的积分
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult<Integer> getCreditById(@PathVariable("id") int id){
        int credit = creditService.getCreditByUserId(id);
        return new JsonResult<>(OK,credit);
    }
}
