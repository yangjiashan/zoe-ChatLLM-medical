package com.zoe.java.ai.langchain4j.assistant;

import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        streamingChatModel = "openAiStreamingChatModel",
        chatModel = "openAiChatModel")
public interface Assistant {
    String chat(String message);

    Flux<String> chatStream(String message);
}
