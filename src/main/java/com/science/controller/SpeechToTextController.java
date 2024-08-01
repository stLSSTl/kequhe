package com.science.controller;

import com.science.service.ISpeechToTextService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeechToTextController extends BaseController{
    @Autowired
    private ISpeechToTextService ispeechToTextService;
    @GetMapping("/speech_to_text")
    public JsonResult<String> getSpeechToText() {
        String result=ispeechToTextService.callSpeechToText();
        return new JsonResult<>(OK,result);
    }
}
