package com.science.service.impl;

import com.science.service.IAIAnswerService;
import com.science.service.ex.AIAnswerServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AIAnswerServiceImpl implements IAIAnswerService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String getAIAnswer() {
        String url = "http://localhost:5000/get_answer";
        Map response = restTemplate.postForObject(url, null, Map.class);
        if (response != null && response.containsKey("ai_answer")) {
            return (String) response.get("ai_answer");
        }
        throw new AIAnswerServiceException("Response does not contain 'ai_answer' key or response is null.");
    }
}
