package com.insightveda.spring_ai_integration.model;

public class CustomChatResponse {

    private String response;

    public CustomChatResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

