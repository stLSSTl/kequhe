package com.science.mapper;

import com.science.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ScoreMapper {
    public Score findScoreById(@Param("id") int id);

    public Integer insertScore(Score score);


    public Integer modifyScore(Score score);

    public List<Score> findScoreByInfo(int studentId,Integer score, String examName, String examDate);

    public List<Score> findScoreByTeacher(int teacherId,String school,String grade,String classes,String examName);

    public List<Score> findScoreByAdmin(String studentName, String school, String grade, String classes, String examName, String examDate);
}
