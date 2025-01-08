package com.insightveda.spring_ai_integration.client;

import com.insightveda.spring_ai_integration.model.CustomChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Component;

@Component
public class OpenAIChatClient implements CustomChatClient {

    private final ChatClient chatClient;

    public OpenAIChatClient(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public CustomChatResponse getChatResponse(String prompt) {
        ChatResponse chatResponse = this.chatClient.prompt()
                .user(prompt)
                .call()
                .chatResponse();

        System.out.println(chatResponse);

        String generatedText = chatResponse.getResult().getOutput().getContent();

        return new CustomChatResponse(generatedText);
    }
}
