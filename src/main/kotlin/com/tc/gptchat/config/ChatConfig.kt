package com.tc.gptchat.config

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor
import org.springframework.ai.chat.memory.ChatMemory
import org.springframework.ai.chat.memory.InMemoryChatMemory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource

@Configuration
class ChatConfig {

    @Value("classpath:/prompts/path-buddy.txt")
    private lateinit var systemPrompt: Resource

    @Bean
    fun chatMemory() = InMemoryChatMemory()

    @Bean
    fun chatClient(chatClientBuilder: ChatClient.Builder, chatMemory: ChatMemory): ChatClient {
        return chatClientBuilder
            .defaultSystem(systemPrompt)
            .defaultAdvisors(
                PromptChatMemoryAdvisor(chatMemory),
                SimpleLoggerAdvisor()
            )
            .build()
    }

}