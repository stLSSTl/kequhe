package com.science.controller;

import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisResult;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.science.controller.ex.AIPainterException;
import com.science.service.IAiPainterService;
import com.science.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.science.controller.BaseController.OK;

@RestController
public class AiPainterController {
    @Autowired
    IAiPainterService iaiPainterService;

    @GetMapping("/aiPainter")
    public JsonResult<String> aiPainter(@RequestParam("prompt") String prompt){
        try{
            ImageSynthesisResult result = iaiPainterService.generateImage(prompt);
            String firstImageUrl = result.getOutput().getResults().get(0).toString();
            return new JsonResult<String>(OK,firstImageUrl);
        } catch (NoApiKeyException e) {
            throw new AIPainterException("AI绘画出现未知异常");
        }
    }
}
