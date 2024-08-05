package com.science.controller;

import com.science.dto.ClassInteractionDTO;
import com.science.dto.TeacherClassDTO;
import com.science.dto.TeacherRegDTO;
import com.science.entity.Student;
import com.science.service.IAliOssService;
import com.science.service.ITeacherService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController extends BaseController{
    @Autowired
    private ITeacherService teacherService;
    @PostMapping("reg")
    public JsonResult<Void> reg(@RequestBody TeacherRegDTO teacherRegDTO){
        teacherService.reg(teacherRegDTO);
        return new JsonResult<Void>(OK);
    }
    @PostMapping("addClasses")
    public JsonResult<Void> addClassesForTeacher(@RequestBody TeacherClassDTO teacherClassDTO){
        teacherService.addClassesForTeacher(teacherClassDTO);
        return new JsonResult<Void>(OK);
    }
    @GetMapping("getAllStudents")
    public JsonResult<List<Student>> getAllStudent(int teacherId){
        List<Student> allStudent=teacherService.getAllStudentByTeacherId(teacherId);
        return new JsonResult<>(OK,allStudent);
    }
    /**
     * 添加课堂互动记录
     * @param classInteractionDTO
     * @return
     */
    @PostMapping("addInteraction")
    public JsonResult<Void> addInteraction(@RequestBody ClassInteractionDTO classInteractionDTO){
        teacherService.addInteraction(classInteractionDTO);
        return new JsonResult<Void>(OK);
    }

    /**
     * 教师根据id删除课堂互动记录
     * @param id
     * @return
     */
    @DeleteMapping("deleteInteraction/{id}")
    public JsonResult<Void> deleteInteraction(@PathVariable("id") int id){
        teacherService.deleteInteraction(id);
        return new JsonResult<Void>(OK);
    }

    /**
     * 教师修改课堂互动记录
     * @param classInteractionDTO
     * @return
     */
    @PostMapping("updateInteraction")
    public JsonResult<Void> updateInteraction(@RequestBody ClassInteractionDTO classInteractionDTO){
        teacherService.updateInteraction(classInteractionDTO);
        return new JsonResult<Void>(OK);
    }
}
