package com.science.service.impl;

import com.science.service.ICreditService;
import com.science.entity.Student;
import com.science.mapper.StudentMapper;
import com.science.service.ex.CreditErrorException;
import com.science.service.ex.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements ICreditService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public int addPoints(int studentId, int point) {
        Integer oldPoint=studentMapper.getCreditByStudentId(studentId);
        if(oldPoint==null){
            throw new StudentNotFoundException("学号对应的学生积分不存在的异常");
        }
        int newPoint=oldPoint+point;
        studentMapper.updateCredit(newPoint,studentId);
        return newPoint;
    }
    /**
     * 返回学生称号
     * @param
     * @return
     */
    @Override
    public String getTitleByCredit(int studentId) {
        Student student = studentMapper.findStudentByStudentId(studentId);
        if(student == null) throw new StudentNotFoundException("该学生不存在");

        int credit = student.getCredit();
        if      (credit >= 0 && credit <= 50) return "学海小苗";
        else if (credit >= 51 && credit <= 100) return "知识幼苗";
        else if (credit >= 101 && credit <= 200) return "学术嫩芽";
        else if (credit >= 201 && credit <= 300) return "学习行者";
        else if (credit >= 301 && credit <= 400) return "学术探索者";
        else if (credit >= 401 && credit <= 500) return "知识航海家";
        else if (credit >= 501 && credit <= 650) return "学术领航员";
        else if (credit >= 651 && credit <= 800) return "学术先锋";
        else if (credit >= 801 && credit <= 1000) return "知识大师";
        else if (credit > 1000) return "终极学者";
        else throw new CreditErrorException("积分出现未知错误");
    }


    @Override
    public List<Student> getCreditByClass(String school,String grade, String classes) {
        List<Student> students = studentMapper.findStudentsByClass(school,grade,classes);
        if(students.isEmpty())    throw new StudentNotFoundException("学生为空");
        return students;
    }

    @Override
    public Integer getCreditByUserId(int studentId) {
        Student student =studentMapper.findStudentByStudentId(studentId);
        if(student==null){
            throw new StudentNotFoundException("未找到学号对应学生异常");
        }
        int credit=studentMapper.getCreditByStudentId(studentId);
        return credit;
    }
}
