package com.univo.backend_app.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final ChatClient chatClient;

    public AIService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String preguntar(String pregunta) {
        return chatClient.prompt()
                .user(pregunta)
                .call()
                .content();
    }
}