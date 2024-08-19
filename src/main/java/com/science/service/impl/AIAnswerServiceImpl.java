package com.science.service.impl;

import com.science.service.IAIAnswerService;
import com.science.service.ex.AIAnswerServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AIAnswerServiceImpl implements IAIAnswerService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String getAIAnswer(String question) {
        String url = "http://121.40.20.34:5000/get_answer";
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("question", question);
        Map response = restTemplate.postForObject(url, requestBody, Map.class);
        if (response != null && response.containsKey("ai_answer")) {
            return (String) response.get("ai_answer");
        }
        throw new AIAnswerServiceException("Response does not contain 'ai_answer' key or response is null.");
    }
}
