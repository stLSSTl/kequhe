package com.science.controller;

import com.science.controller.ex.GetRandomStudentException;
import com.science.dto.ClassInteractionDTO;
import com.science.dto.TeacherClassDTO;
import com.science.dto.TeacherRegDTO;
import com.science.entity.SchoolClassInfo;
import com.science.entity.Student;
import com.science.service.IAliOssService;
import com.science.service.ITeacherService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("teachers")
public class TeacherController extends BaseController{
    @Autowired
    private ITeacherService teacherService;
    @PostMapping("reg")
    public JsonResult<Void> reg(@RequestBody TeacherRegDTO teacherRegDTO){
        teacherService.reg(teacherRegDTO);
        return new JsonResult<>(OK);
    }
    @PostMapping("classes/{teacherId}")
    public JsonResult<Void> addClassesForTeacher(@PathVariable int teacherId,@RequestBody TeacherClassDTO teacherClassDTO){
        teacherClassDTO.setTeacherId(teacherId);
        teacherService.addClassesForTeacher(teacherClassDTO);
        return new JsonResult<>(OK);
    }
    @GetMapping("students/{teacherId}")
    public JsonResult<List<Student>> getAllStudent(@PathVariable int teacherId){
        List<Student> allStudent=teacherService.getAllStudentByTeacherId(teacherId);
        return new JsonResult<>(OK,allStudent);
    }
    @GetMapping("classes/{teacherId}")
    public JsonResult<List<SchoolClassInfo>> getAllClasses(@PathVariable int teacherId){
        List<SchoolClassInfo> allClass=teacherService.getALLClassByTeacherId(teacherId);
        return new JsonResult<>(OK,allClass);
    }
    @PostMapping("student/ByClassInfo")
    public JsonResult<List<Student>> getStudentsByClassInfo(@RequestBody SchoolClassInfo schoolClassInfo){
        List<Student> list=teacherService.getStudentByClassInfo(schoolClassInfo);
        return new JsonResult<>(OK,list);
    }
    @PostMapping("student/random")
    public JsonResult<Student> getRandomStudent(@RequestBody SchoolClassInfo schoolClassInfo){
        List<Student> list=teacherService.getStudentByClassInfo(schoolClassInfo);
        if(list==null||list.isEmpty()){
            throw new GetRandomStudentException("获取学生表单异常");
        }
        Random random=new Random();
        int randomIndex=random.nextInt(list.size());
        Student student=list.get(randomIndex);
        return new JsonResult<>(OK,student);
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
