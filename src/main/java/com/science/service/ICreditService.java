package com.science.service;

import com.science.entity.Student;
import com.science.entity.Student;

import java.util.List;

public interface ICreditService {
    public String getTitleByCredit(int id);
    public List<Student> getCreditByClass(String school, String grade, String classes);
    public Integer getCreditByStudentId(int id);
    public int addPoints(int studentId,int point);
}
