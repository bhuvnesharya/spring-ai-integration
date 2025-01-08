package com.insightveda.spring_ai_integration.client;

import com.insightveda.spring_ai_integration.model.CustomChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestChatClient implements CustomChatClient {

    private final String apiKey;
    private final RestTemplate restTemplate;

    public RestChatClient(RestTemplateBuilder restTemplateBuilder, @Value("${openai.api-key}") String apiKey) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiKey = apiKey;
    }

    @Override
    public CustomChatResponse getChatResponse(String prompt) {
        String apiUrl = "https://api.openai.com/v1/chat/completions";

        // Build request
        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("messages", List.of(message));
        requestBody.put("max_tokens", 100);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Call API
        ResponseEntity<Map> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, Map.class);
        Map<String, Object> responseBody = responseEntity.getBody();

        System.out.println(responseBody);

        // Extract response
        List<Map<String, Object>> choices = (List<Map<String, Object>>) responseBody.get("choices");
        Map<String, Object> firstChoice = choices.get(0);
        String generatedText = (String) ((Map<String, Object>) firstChoice.get("message")).get("content");

        return new CustomChatResponse(generatedText);
    }

}
