package com.science.service.impl;

import com.science.dto.AnswerDTO;
import com.science.dto.QuestionDTO;
import com.science.dto.ReplyDTO;
import com.science.entity.Answer;
import com.science.entity.Question;
import com.science.entity.Reply;
import com.science.mapper.AnswerMapper;
import com.science.mapper.QuestionMapper;
import com.science.mapper.ReplyMapper;
import com.science.mapper.UserMapper;
import com.science.service.ICommentService;
import com.science.service.ex.DeleteException;
import com.science.service.ex.InsertException;
import com.science.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<QuestionDTO> getAllComments() {
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        List<Question> questionList=questionMapper.getAllQuestions();
        for(Question x:questionList){

            QuestionDTO questionDTO=QuestionConvertToDTO(x);

            List<Answer> answerList=answerMapper.getAnswersByQuestionId(x.getQuestionId());
            List<AnswerDTO> answerDTOList=new ArrayList<>();

            for(Answer y:answerList){
                AnswerDTO answerDTO=AnswerConvertToDTO(y);
                List<Reply> replyList=replyMapper.getRepliesByAnswerId(y.getAnswerId());
                List<ReplyDTO> replyDTOList=new ArrayList<>();
                for(Reply z:replyList){
                    ReplyDTO replyDTO=ReplyConvertToDTO(z);
                    replyDTOList.add(replyDTO);
                }
                answerDTO.setReplies(replyDTOList);
                answerDTOList.add(answerDTO);
            }
            questionDTO.setAnswers(answerDTOList);

            questionDTOList.add(questionDTO);

        }
        return questionDTOList;
    }

    @Override
    public void addQuestion(QuestionDTO questionDTO) {
        Question question=DTOConvertToEntity(questionDTO);
        question.setCreateTime(new Date());
        Integer rows=questionMapper.insertQuestion(question);
        if(rows!=1){
            throw new InsertException("插入时异常");
        }
    }

    @Override
    public void addAnswer(AnswerDTO answerDTO) {
        Answer answer=DTOConvertToEntity(answerDTO);
        answer.setCreateTime(new Date());
        Integer rows=answerMapper.insertAnswer(answer);
        if(rows!=1){
            throw new InsertException("插入时异常");
        }
    }

    @Override
    public void addReply(ReplyDTO replyDTO) {
        Reply reply=DTOConvertToEntity(replyDTO);
        reply.setCreateTime(new Date());
        Integer rows=replyMapper.insertReply(reply);
        if(rows!=1){
            throw new InsertException("插入时异常");
        }
    }

    @Override
    public void deleteReply(int replyId) {
        try{
            replyMapper.deleteReply(replyId);
        }catch (Exception e){
            throw new DeleteException("删除时发生异常");
        }
    }

    @Override
    public void deleteAnswer(int answerId) {
        try {
            answerMapper.deleteAnswer(answerId);
        }catch (Exception e){
            throw new DeleteException("删除时发生异常");
        }
    }

    @Override
    public void deleteQuestion(int questionId) {
        try {
            questionMapper.deleteQuestion(questionId);
        }catch (Exception e){
            throw new DeleteException("删除时发生异常");
        }
    }

    public QuestionDTO QuestionConvertToDTO(Question question){
        QuestionDTO questionDTO=new QuestionDTO();
        questionDTO.setQuestionId(question.getQuestionId());
        questionDTO.setTitle(question.getTitle());
        questionDTO.setContent(question.getContent());
        questionDTO.setUsername(question.getUsername());
        questionDTO.setCreateTime(question.getCreateTime());
        return questionDTO;
    }
    public Question DTOConvertToEntity(QuestionDTO questionDTO){
        Question question=new Question();
        question.setQuestionId(questionDTO.getQuestionId());
        question.setContent(questionDTO.getContent());
        question.setCreateTime(questionDTO.getCreateTime());
        question.setUsername(questionDTO.getUsername());
        question.setTitle(questionDTO.getTitle());
        Integer userId=userMapper.getUidByUsername(questionDTO.getUsername());
        if(userId==null){
            throw new UserNotFoundException("该用户不存在的异常");
        }
        question.setUserId(userId);
        return question;
    }
    public AnswerDTO AnswerConvertToDTO(Answer answer){
        AnswerDTO answerDTO=new AnswerDTO();
        answerDTO.setAnswerId(answer.getAnswerId());
        answerDTO.setContent(answer.getContent());
        answerDTO.setQuestionId(answer.getQuestionId());
        answerDTO.setCreateTime(answer.getCreateTime());
        answerDTO.setUsername(answer.getUsername());
        return answerDTO;
    }
    public Answer DTOConvertToEntity(AnswerDTO answerDTO){
        Answer answer=new Answer();
        answer.setAnswerId(answerDTO.getAnswerId());
        answer.setContent(answerDTO.getContent());
        answer.setCreateTime(answerDTO.getCreateTime());
        answer.setUsername(answerDTO.getUsername());
        answer.setQuestionId(answerDTO.getQuestionId());
        Integer userId=userMapper.getUidByUsername(answerDTO.getUsername());
        if(userId==null){
            throw new UserNotFoundException("该用户不存在的异常");
        }
        answer.setUserId(userId);
        return answer;
    }
    public ReplyDTO ReplyConvertToDTO(Reply reply){
        ReplyDTO replyDTO=new ReplyDTO();
        replyDTO.setReplyId(reply.getReplyId());
        replyDTO.setContent(reply.getContent());
        replyDTO.setAnswerId(reply.getAnswerId());
        replyDTO.setUsername(reply.getUsername());
        replyDTO.setCreateTime(reply.getCreateTime());
        return  replyDTO;
    }
    public Reply DTOConvertToEntity(ReplyDTO replyDTO){
        Reply reply=new Reply();
        reply.setReplyId(replyDTO.getReplyId());
        reply.setContent(replyDTO.getContent());
        reply.setAnswerId(replyDTO.getAnswerId());
        reply.setUsername(replyDTO.getUsername());
        reply.setCreateTime(replyDTO.getCreateTime());
        Integer userId=userMapper.getUidByUsername(replyDTO.getUsername());
        if(userId==null){
            throw new UserNotFoundException("该用户不存在的异常");
        }
        reply.setUserId(userId);
        return reply;
    }
}
