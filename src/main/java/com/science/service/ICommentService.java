package com.science.service;

import com.science.dto.AnswerDTO;
import com.science.dto.QuestionDTO;
import com.science.dto.ReplyDTO;

import java.util.List;

public interface ICommentService {
    public List<QuestionDTO> getAllComments();
    public void addQuestion(QuestionDTO questionDTO);
    public void addAnswer(AnswerDTO answerDTO);
    public void addReply(ReplyDTO replyDTO);
}
