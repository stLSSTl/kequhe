package com.science.controller;

import com.science.dto.ParentDTO;
import com.science.dto.StudentRegDTO;
import com.science.dto.StudentUpdateDTO;
import com.science.dto.TeacherDTO;
import com.science.service.IAdminService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

@RestController
@RequestMapping("admin")
public class AdminController extends BaseController {
    @Autowired
    private IAdminService adminService;



    /**
     * 管理员新增学生
     * 新学生默认积分为0，前端可以不传回积分
     * @param studentRegDTO
     * @return
     */
    @PostMapping("addStudent")
    public JsonResult<Void> addStudent(@RequestBody StudentRegDTO studentRegDTO){
        adminService.addStudent(studentRegDTO);
        return new JsonResult<Void>(OK);
    }

    /**
     * 管理员根据学生id删除学生信息
     * 前端传回的id是学生的userId
     * @param id
     * @return
     */
    @DeleteMapping("deleteStudent/{id}")
    public JsonResult<Void> deleteStudent(@PathVariable("id") int id){
        adminService.deleteStudent(id);
        return new JsonResult<Void>(OK);
    }

    /**
     * 管理员修改学生信息
     * @return
     */
    @PostMapping("updateStudent")
    public JsonResult<Void> updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO){
        adminService.updateStudent(studentUpdateDTO);
        return new JsonResult<Void>(OK);
    }

    /**
     * 管理员新增老师
     * @param teacherDTO
     * @return
     */
    @PostMapping("addTeacher")
    public JsonResult<Void> addTeacher(@RequestBody TeacherDTO teacherDTO){
        adminService.addTeacher(teacherDTO);
        return new JsonResult<Void>(OK);
    }

    /**
     * 管理员根据老师姓名删除老师
     * @param id
     * @return
     */
    @DeleteMapping("deleteTeacher/{id}")
    public JsonResult<Void> deleteTeacher(@PathVariable("id") int id){
        adminService.deleteTeacher(id);
        return new JsonResult<Void>(OK);
    }

    /**
     * 管理员修改老师信息
     * @param teacherDTO
     * @return
     */
    @PostMapping("updateTeacher")
    public JsonResult<Void> updateTeacher(@RequestBody TeacherDTO teacherDTO){
        adminService.updateTeacher(teacherDTO);
        return new JsonResult<Void>(OK);
    }

    /**
     * 管理员新增家长
     * @param parentDTO
     * @return
     */
    @PostMapping("addParent")
    public JsonResult<Void> addParent(@RequestBody ParentDTO parentDTO){
        adminService.addParent(parentDTO);
        return new JsonResult<Void>(OK);
    }

    /**
     * 管理员根据家长id删除家长
     * @param id
     * @return
     */
    @DeleteMapping("deleteParent/{id}")
    public JsonResult<Void> deleteParent(@PathVariable("id") int id){
        adminService.deleteParent(id);
        return new JsonResult<Void>(OK);
    }

    /**
     * 修改家长信息
     * @return
     */
    @PostMapping("updateParent")
    public JsonResult<Void> updateParent(@RequestBody ParentDTO parentDTO){
        adminService.updateParent(parentDTO);
        return new JsonResult<Void>(OK);
    }
}
