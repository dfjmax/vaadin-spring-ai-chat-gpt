package com.tc.gptchat.views.chat

enum class Participant(val displayName: String, val className: String, val avatarUrl: String) {
    SYSTEM("Path Buddy", "system-message", "path-buddy.png"),
    USER("Explorer", "user-message", "explorer.png")
}