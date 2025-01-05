package com.insightveda.spring_ai_integration.controller;

import com.insightveda.spring_ai_integration.client.ChatClient;
import com.insightveda.spring_ai_integration.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatClient chatClient;

    @PostMapping
    public ResponseEntity<ChatResponse> getChatResponse(@RequestBody String prompt) {
        ChatResponse response = chatClient.getChatResponse(prompt);
        return ResponseEntity.ok(response);
    }
}

