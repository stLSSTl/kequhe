package com.science.mapper;

import com.science.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    public List<Question> getAllQuestions();
    public Question getQuestionById(int questionId);//暂时没用
    public Integer insertQuestion(Question question);
}
