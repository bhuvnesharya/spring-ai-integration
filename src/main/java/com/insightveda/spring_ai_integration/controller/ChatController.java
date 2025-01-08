package com.insightveda.spring_ai_integration.controller;

import com.insightveda.spring_ai_integration.client.OpenAIChatClient;
import com.insightveda.spring_ai_integration.client.RestChatClient;
import com.insightveda.spring_ai_integration.model.CustomChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private RestChatClient restChatClient;

    @Autowired
    private OpenAIChatClient openAIChatClient;

    // Method for RestChatClient implementation
    @PostMapping("/rest")
    public ResponseEntity<CustomChatResponse> getRestChatResponse(@RequestBody String prompt) {
        // Using RestChatClient to get response
        CustomChatResponse response = restChatClient.getChatResponse(prompt);
        return ResponseEntity.ok(response);
    }

    // Method for OpenAIChatClient implementation
    @PostMapping("/openai")
    public ResponseEntity<CustomChatResponse> getOpenAIChatResponse(@RequestBody String prompt) {
        // Using OpenAIChatClient to get response
        CustomChatResponse response = openAIChatClient.getChatResponse(prompt);
        return ResponseEntity.ok(response);
    }
}
