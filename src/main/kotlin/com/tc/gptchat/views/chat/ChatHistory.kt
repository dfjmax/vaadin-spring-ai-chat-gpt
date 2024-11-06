package com.tc.gptchat.views.chat

import com.vaadin.flow.component.messages.MessageList
import com.vaadin.flow.component.messages.MessageListItem
import com.vaadin.flow.theme.lumo.LumoUtility.Background
import com.vaadin.flow.theme.lumo.LumoUtility.Border
import com.vaadin.flow.theme.lumo.LumoUtility.BorderRadius
import com.vaadin.flow.theme.lumo.LumoUtility.Margin
import java.time.Instant

class ChatHistory : MessageList() {

    private val chatHistory = mutableListOf<MessageListItem>()

    init {
        setSizeFull()
        addClassNames(Border.ALL)
    }

    fun addChatMessage(message: String, participant: Participant): MessageListItem {
        val messageListItem = MessageListItem(message, Instant.now(), participant.displayName).apply {
            addClassNames(Margin.SMALL, BorderRadius.LARGE)
            userImage = "images/${participant.avatarUrl}"
        }

        if (participant == Participant.USER) {
            messageListItem.addClassNames(Background.CONTRAST_5)
        }

        chatHistory.add(messageListItem)
        setItems(chatHistory)
        return messageListItem
    }

    fun scrollToBottom() {
        element.executeJs("this.scrollTop = this.scrollHeight;")
    }

}