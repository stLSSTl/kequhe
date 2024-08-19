package com.science.controller;

import com.science.service.IAIAnswerService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIAnswerController extends BaseController{
    @Autowired
    private IAIAnswerService aiAnswerService;
    @GetMapping("/get_ai_answer")
    public JsonResult<String> getAIAnswer(String question) {
        String aiAnswer = aiAnswerService.getAIAnswer(question);
        return new JsonResult<>(200, aiAnswer);
    }
}
