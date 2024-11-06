package com.tc.gptchat.views.chat

import com.tc.gptchat.service.ChatService
import com.tc.gptchat.views.MainLayout
import com.tc.gptchat.views.chat.Participant.SYSTEM
import com.tc.gptchat.views.chat.Participant.USER
import com.vaadin.flow.component.AttachEvent
import com.vaadin.flow.component.messages.MessageInput
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

@Route("", layout = MainLayout::class)
@PageTitle("AI Chat")
class ChatView(private val chatService: ChatService) : VerticalLayout() {

    private val chatHistory = ChatHistory()
    private val chatInput = MessageInput().apply { setWidthFull() }
    private val chatId = UUID.randomUUID()

    init {
        add(chatHistory, chatInput)
        configureChatInput()
        setSizeFull()
    }

    private fun configureChatInput() {
        chatInput.addSubmitListener {
            if (it.value.isNotBlank()) {
                handleUserMessage(it.value)
            }
        }
    }

    private fun handleUserMessage(userMessage: String) {
        chatHistory.addChatMessage(userMessage, USER)
        chatInput.isEnabled = false
        handleChatResponse(userMessage)
    }

    private fun handleChatResponse(userMessage: String) {
        val systemMessageBuilder = StringBuilder()

        val systemMessageListItem by lazy {
            chatHistory.addChatMessage(systemMessageBuilder.toString(), SYSTEM)
        }

        chatService.getResponse(chatId, userMessage)
            .doFinally {
                ui.getOrNull()?.access {
                    chatInput.isEnabled = true
                    chatInput.focus()
                }
            }
            .subscribe {
                systemMessageBuilder.append(it)
                ui.getOrNull()?.access {
                    systemMessageListItem.text = systemMessageBuilder.toString()
                    chatHistory.scrollToBottom()
                }
            }
    }

    override fun onAttach(attachEvent: AttachEvent) {
        super.onAttach(attachEvent)
        handleChatResponse("Introduce yourself briefly.")
    }

}