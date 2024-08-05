package com.science.service;

import com.science.dto.ScoreDTO;
import com.science.entity.Score;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface IScoreService {
    public void manualAdd(ScoreDTO scoreDTO);
    public void uploadScore(MultipartFile file) throws IOException;
    public void updateScore(ScoreDTO scoreDTO);
    public List<Score> studentQuery(int studentId,String score, String examName, String examDate);
    public List<Score> teacherQuery(int teacherId,String school,String grade,String classes,String examName);
    public List<Score> adminQuery(String studentName,String school,String grade,String classes,String examName,String examDate);
}
