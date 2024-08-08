package com.science.controller;

import com.science.dto.AnswerDTO;
import com.science.dto.QuestionDTO;
import com.science.dto.ReplyDTO;
import com.science.service.ICommentService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("comment")
public class CommentController extends BaseController{
    @Autowired
    private ICommentService commentService;
    @GetMapping("getAll")
    public JsonResult<List<QuestionDTO>> getAllComments(){
        List<QuestionDTO> questionDTOList=commentService.getAllComments();
        return new JsonResult<>(OK,questionDTOList);
    };
    @PostMapping("addQuestion")
    public JsonResult<Void> addQuestion(@RequestBody QuestionDTO questionDTO){
        commentService.addQuestion(questionDTO);
        return new JsonResult<>(OK);
    }
    @PostMapping("addAnswer")
    public JsonResult<Void> addAnswer(@RequestBody AnswerDTO answerDTO){
        commentService.addAnswer(answerDTO);
        return new JsonResult<>(OK);
    }
    @PostMapping("deleteAnswer")
    public JsonResult<Void> deleteAnswer(int answerId){
        commentService.deleteAnswer(answerId);
        return new JsonResult<>(OK);
    }
    @PostMapping("addReply")
    public JsonResult<Void> addReply(@RequestBody ReplyDTO replyDTO){
        commentService.addReply(replyDTO);
        return new JsonResult<Void>(OK);
    }
    @PostMapping("deleteReply")
    public JsonResult<Void> deleteReply(int replyId){
        commentService.deleteReply(replyId);
        return new JsonResult<>(OK);
    }
    @PostMapping("deleteQuestion")
    public JsonResult<Void> deleteQuestion(int questionId){
        commentService.deleteQuestion(questionId);
        return new JsonResult<>(OK);
    }
}
