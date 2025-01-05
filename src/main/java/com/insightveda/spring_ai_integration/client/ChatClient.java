package com.insightveda.spring_ai_integration.client;

import com.insightveda.spring_ai_integration.model.ChatResponse;

public interface ChatClient {
    ChatResponse getChatResponse(String prompt);
}

