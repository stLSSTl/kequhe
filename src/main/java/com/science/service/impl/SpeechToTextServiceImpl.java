package com.science.service.impl;

import com.science.service.ISpeechToTextService;
import com.science.service.ex.SpeechToTextException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class SpeechToTextServiceImpl implements ISpeechToTextService {
    private final RestTemplate restTemplate;
    public SpeechToTextServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public String callSpeechToText() {
        String url = "http://localhost:5000/speech_to_text";

        // 创建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // 发送请求
        HttpEntity<String> request = new HttpEntity<>(null, headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> responseMap = response.getBody();
            String result = responseMap != null ? (String) responseMap.get("result") : null;
            return result;
        } else {
            throw new SpeechToTextException(String.format("请求失败，状态码：%s，响应：%s",
                    response.getStatusCode(), response.getBody()));
        }
    }
}
