package com.zoe.java.ai.langchain4j;

import com.zoe.java.ai.langchain4j.assistant.Assistant;
import com.zoe.java.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.agent.tool.ToolSpecification;
import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.McpClient;
import dev.langchain4j.mcp.client.transport.McpTransport;
import dev.langchain4j.mcp.client.transport.stdio.StdioMcpTransport;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.tool.ToolProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class McpTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Autowired
    private OpenAiChatModel openAiChatModel;

    private ChatMemoryProvider chatMemoryProvider;

    @Test
    public void testCalculatorTools() throws Exception {

        String answer = separateChatAssistant.chat(102, "推荐几个福州的美食");
        //答案：3，689706.4865
        System.out.println(answer);
//
//        McpTransport transport = new StdioMcpTransport.Builder()
////                .command(List.of("/usr/local/bin/docker", "run", "-e", "GITHUB_PERSONAL_ACCESS_TOKEN", "-i", "mcp/github"))
//                .command(List.of("npx.cmd", "-y", "@modelcontextprotocol/server-github"))
//                .logEvents(true)
//                .build();
//
//        McpClient mcpClient = new DefaultMcpClient.Builder()
//                .transport(transport)
//                .build();
//
//
////        List<String> toolList = List.of("github");
//
//        McpToolProvider toolProvider = McpToolProvider.builder()
//                .mcpClients(List.of(mcpClient))
////                .filter((client, tool) ->
////                        toolList.contains(tool.name()))
//                .build();
//
//        Assistant bot = AiServices.builder(Assistant.class)
//                .chatLanguageModel(openAiChatModel)
//                .toolProvider(toolProvider)
//                .chatMemoryProvider(chatMemoryProvider)
//                .build();
//
//        try {
//            String response = bot.chat("Summarize the last 3 commits of the yangjiashan/SpringCloudAlibaba GitHub repository");
//            System.out.println("RESPONSE: " + response);
//        } finally {
//            mcpClient.close();
//        }
    }
}