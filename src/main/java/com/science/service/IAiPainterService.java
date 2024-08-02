package com.science.service;

import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisResult;
import com.alibaba.dashscope.exception.NoApiKeyException;

public interface IAiPainterService {
    public ImageSynthesisResult generateImage(String prompt) throws NoApiKeyException;
}
