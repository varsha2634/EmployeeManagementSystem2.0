package com.example.employeetaskmanagement.service;
import com.example.employeetaskmanagement.model.ChatMessage;
public interface ChatService {
    ChatMessage saveChatMessage(ChatMessage chatMessage);
    ChatMessage getChatMessageById(String id);
    void deleteChatMessage(String id);
}