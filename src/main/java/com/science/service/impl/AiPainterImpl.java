package com.science.service.impl;

import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesis;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisParam;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisResult;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.science.service.IAiPainterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AiPainterImpl implements IAiPainterService {
    private String apiKey;

    @Value("${multimedia.apiKey}")
    public void setApiKey(String apiKey){
        this.apiKey = apiKey;
    }
    @Override
    public ImageSynthesisResult generateImage(String prompt) throws NoApiKeyException {
        ImageSynthesis imageSynthesis = new ImageSynthesis();
        ImageSynthesisParam param = ImageSynthesisParam.builder()
                .model(ImageSynthesis.Models.WANX_V1)
                .apiKey(apiKey)
                .n(4)
                .size("1024*1024")
                .prompt(prompt)
                .build();
        return imageSynthesis.call(param);
    }
}

