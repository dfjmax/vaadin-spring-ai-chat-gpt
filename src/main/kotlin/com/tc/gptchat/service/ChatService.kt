package com.tc.gptchat.service

import java.net.ConnectException
import java.util.UUID
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ChatService(private val chatClient: ChatClient) {

    fun getResponse(chatId: UUID, userMessage: String): Flux<String> {
        return chatClient.prompt()
            .advisors { it.param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId) }
            .user(userMessage)
            .stream()
            .content()
            .onErrorResume {
                Flux.just(
                    when (it.cause) {
                        is ConnectException -> "Oops! It seems I’m having trouble reaching the server. Please give it a moment and try again soon."
                        else -> "Something went wrong on my end. I’ll look into it — feel free to try again shortly!"
                    }
                )
            }
    }

}