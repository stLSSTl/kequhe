package com.science.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.science.dto.ClassInteractionDTO;
import com.science.dto.CourseVideoDTO;
import com.science.dto.TeacherRegDTO;
import com.science.entity.ClassInteraction;
import com.science.service.ITeacherService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    /**
     * 添加视频
     * @param
     * @return
     */
    @PostMapping("addVideo")
    public JsonResult<Void> addVideo(@RequestParam String courseVideoDTOJson,
                                     @RequestParam MultipartFile file) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CourseVideoDTO courseVideoDTO = objectMapper.readValue(courseVideoDTOJson, CourseVideoDTO.class);
        teacherService.addVideo(courseVideoDTO,file);
        return new JsonResult<Void>(OK);
    }

    /**
     * 根据id删除视频
     * @param id
     * @return
     */
    @DeleteMapping("deleteVideo/{id}")
    public JsonResult<Void> deleteVideo(@PathVariable("id") int id){
        teacherService.deleteVideo(id);
        return new JsonResult<Void>(OK);
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
