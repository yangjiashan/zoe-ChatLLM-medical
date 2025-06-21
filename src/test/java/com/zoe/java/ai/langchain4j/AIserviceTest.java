package com.zoe.java.ai.langchain4j;

import com.zoe.java.ai.langchain4j.assistant.Assistant;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
public class AIserviceTest {

    @Autowired
    private OpenAiStreamingChatModel openAiStreamingChatModel;

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testChat() {
        //创建AIService
        Assistant assistant = AiServices.create(Assistant.class, openAiChatModel);
        //调用service的接口
        String answer = assistant.chat("Hello");
        System.out.println(answer);
    }

    @Autowired
    private Assistant assistant;

    @Test
    public void testAssistant() {
        String answer = assistant.chat("Hello");
        System.out.println(answer);
    }

    @Test
    public void testAssistantStream() {
        Flux<String> hello = assistant.chatStream("Hello");
        hello.subscribe(System.out::println);
    }
}
