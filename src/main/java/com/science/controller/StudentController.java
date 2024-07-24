package com.science.controller;

import com.science.dto.StudentRegDTO;
import com.science.service.IStudentService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("students")
public class StudentController extends BaseController{
    @Autowired
    private IStudentService studentService;
    @PostMapping("reg")
    public JsonResult<Void> reg(@RequestBody StudentRegDTO studentRegDTO){
        studentService.reg(studentRegDTO);
        return new JsonResult<Void>(OK);
    }
}
