package com.zoe.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel",
        chatMemory = "chatMemory",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "calculatorTools" //配置tools,这里调用bean对象，用小写开头
)
public interface SeparateChatAssistant {

    /**
     * 分离聊天记录
     *
     * @param memoryId    聊天id
     * @param userMessage 用户消息
     * @return
     */
    //@SystemMessage("我是你的儿子，请用邯郸话回答问题。")//切换系统提示词，会丢到以前的记忆
    //@SystemMessage("你是我的儿子，请用东北话回答问题。")//系统消息提示词
    //@SystemMessage("你是我的好朋友，请用东北话回答问题。今天是{{current_date}}")//系统消息提示词
//    @SystemMessage(fromResource = "my-prompt-template.txt")
    @SystemMessage("你是一个美食领域人工智能助手，涉及到美食领域外的问题，你应该礼貌拒绝回答（如：很抱歉，我是一个美食领域人工智能助手，无法回答您其它领域问题）。")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @UserMessage("你是我的好朋友，请用粤语回答问题。{{message}}")
    String chat2(@MemoryId int memoryId, @V("message") String userMessage);

    @SystemMessage(fromResource = "my-prompt-template2.txt")
    String chat3(
            @MemoryId int memoryId,
            @UserMessage String userMessage,
            @V("username") String username,
            @V("age") int age
    );
}