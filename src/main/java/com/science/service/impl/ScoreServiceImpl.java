package com.science.service.impl;

import com.science.dto.ScoreDTO;
import com.science.entity.Score;
import com.science.mapper.ScoreMapper;
import com.science.service.IScoreService;
import com.science.service.ex.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class ScoreServiceImpl implements IScoreService {
    @Autowired
    ScoreMapper scoreMapper;

    /**
     * 手动添加成绩
     * @param scoreDTO
     */
    @Override
    public void manualAdd(ScoreDTO scoreDTO) {
        //成绩检查范围
        if(scoreDTO.getScore()>100 || scoreDTO.getScore()<0){
            throw new ScoreNumberError("成绩超出范围");
        }
        //检查是否已经存在
        if(scoreMapper.findScoreById(scoreDTO.getScoreId()) != null){
            throw new ScoreIdDuplicatedException("该成绩记录已经存在");
        }

        Score score = new Score();
        BeanUtils.copyProperties(scoreDTO,score);   //将scoreDTO里的东西赋值到score中
        Integer rows = scoreMapper.insertScore(score);
        if(rows != 1)   throw new InsertException("插入数据时发生未知异常");
    }

    @Override
    public void uploadScore(MultipartFile file) throws IOException {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();

            while (iterator.hasNext()) {
                Row row = iterator.next();
                Score score = new Score();
                //插入数据前需要检查对应的记录是否存在
                if(scoreMapper.findScoreById((int) row.getCell(0).getNumericCellValue()) != null){
                    throw new ScoreIdDuplicatedException("该成绩记录已存在");
                }
                //年级和班级那两栏不能纯数字
                //判断年级和班级是否是string类型
                Cell gradeCell = row.getCell(4);
                Cell classCell = row.getCell(5);
                if (gradeCell.getCellType() != CellType.STRING || classCell.getCellType() != CellType.STRING) {
                    throw new InsertException("年级或班级必须为字符串类型");
                }
                //成绩检查范围
                if((int) row.getCell(6).getNumericCellValue()>100 || (int) row.getCell(6).getNumericCellValue()<0){
                    throw new ScoreNumberError("成绩超出范围");
                }
                score.setScoreId((int) row.getCell(0).getNumericCellValue());
                score.setStudentId((int) row.getCell(1).getNumericCellValue());
                score.setStudentName(row.getCell(2).getStringCellValue());
                score.setSchool(row.getCell(3).getStringCellValue());
                score.setGrade(row.getCell(4).getStringCellValue());    //年级和班级那两栏不能纯数字
                score.setClasses(row.getCell(5).getStringCellValue());
                score.setScore((int) row.getCell(6).getNumericCellValue());
                score.setExamName(row.getCell(7).getStringCellValue());
                score.setExamDate(row.getCell(8).getDateCellValue());

                Integer rows = scoreMapper.saveScore(score);
                if(rows != 1)   throw new InsertException("插入数据时出现未知错误");
            }
        }
    }

    @Override
    public void updateScore(ScoreDTO scoreDTO) {
        //先判断该成绩记录表是否存在
        Score res = scoreMapper.findScoreById(scoreDTO.getScoreId());
        if(res == null) throw new ScoreRecordNotFoundException("该成绩记录不存在");

        Score score = new Score();
        BeanUtils.copyProperties(scoreDTO,score);   //将scoreDTO里的东西赋值到score中

        Integer rows = scoreMapper.modifyScore(score);
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }

    @Override
    public List<Score> studentQuery(int studentId,Integer score, String examName, String examDate) {
        List<Score> scores = scoreMapper.findScoreByInfo(studentId,score,examName,examDate);
        if (scores.isEmpty()) throw new ScoreRecordNotFoundException("成绩记录表为空");
        return scores;
    }

    @Override
    public List<Score> teacherQuery(int teacherId, String school, String grade, String classes, String examName) {
        List<Score> scores = scoreMapper.findScoreByTeacher(teacherId, school, grade, classes, examName);
        if (scores.isEmpty()) throw new ScoreRecordNotFoundException("成绩记录表为空");
        return scores;
    }

    @Override
    public List<Score> adminQuery(String studentName, String school, String grade, String classes, String examName, String examDate) {
        List<Score> scores = scoreMapper.findScoreByAdmin(studentName,school,grade,classes,examName,examDate);
        if (scores.isEmpty()) throw new ScoreRecordNotFoundException("成绩记录表为空");
        return scores;
    }


}
