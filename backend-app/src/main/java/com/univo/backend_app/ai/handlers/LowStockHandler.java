package com.univo.backend_app.ai.handlers;

import com.univo.backend_app.ai.Intent;
import com.univo.backend_app.ai.prompts.LowStockPromptBuilder;
import com.univo.backend_app.repositories.AIRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LowStockHandler implements AIHandler {

    private final AIRepository repository;
    private final LowStockPromptBuilder promptBuilder;
    private final ChatClient chatClient;

    public LowStockHandler(
            AIRepository repository,
            LowStockPromptBuilder promptBuilder,
            ChatClient.Builder builder) {

        this.repository = repository;
        this.promptBuilder = promptBuilder;
        this.chatClient = builder.build();

    }

    @Override
    public Intent supports() {

        return Intent.LOW_STOCK;

    }

    @Override
    public String handle(String question) {

        List<Map<String,Object>> products =
                repository.getLowStockProducts();

        String prompt = promptBuilder.build(products);

        return chatClient
                .prompt(prompt)
                .call()
                .content();

    }

}