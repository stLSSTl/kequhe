package com.science.mapper;

import com.science.entity.Answer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerMapper {
    public List<Answer> getAnswersByQuestionId(int questionId);
    public Integer insertAnswer(Answer answer);
}
