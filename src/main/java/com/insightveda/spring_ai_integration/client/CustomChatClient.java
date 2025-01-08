package com.insightveda.spring_ai_integration.client;

import com.insightveda.spring_ai_integration.model.CustomChatResponse;

public interface CustomChatClient {
    CustomChatResponse getChatResponse(String prompt);
}

