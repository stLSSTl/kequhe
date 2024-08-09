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
    @PostMapping("Questions")
    public JsonResult<Void> addQuestion(@RequestBody QuestionDTO questionDTO){
        commentService.addQuestion(questionDTO);
        return new JsonResult<>(OK);
    }
    @PostMapping("Answers")
    public JsonResult<Void> addAnswer(@RequestBody AnswerDTO answerDTO){
        commentService.addAnswer(answerDTO);
        return new JsonResult<>(OK);
    }
    @DeleteMapping("Answers/{answerId}")
    public JsonResult<Void> deleteAnswer(@PathVariable int answerId){
        commentService.deleteAnswer(answerId);
        return new JsonResult<>(OK);
    }
    @PostMapping("Replies")
    public JsonResult<Void> addReply(@RequestBody ReplyDTO replyDTO){
        commentService.addReply(replyDTO);
        return new JsonResult<>(OK);
    }
    @DeleteMapping("Replies/{replyId}")
    public JsonResult<Void> deleteReply(@PathVariable int replyId){
        commentService.deleteReply(replyId);
        return new JsonResult<>(OK);
    }
    @DeleteMapping("Questions/{questionId}")
    public JsonResult<Void> deleteQuestion(@PathVariable int questionId){
        commentService.deleteQuestion(questionId);
        return new JsonResult<>(OK);
    }
}
