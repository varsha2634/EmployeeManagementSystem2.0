package com.example.employeetaskmanagement.service;
import com.example.employeetaskmanagement.model.ChatMessage;
import com.example.employeetaskmanagement.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Override
    public ChatMessage saveChatMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }
    @Override
    public ChatMessage getChatMessageById(String id) {
        return chatMessageRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteChatMessage(String id) {
        chatMessageRepository.deleteById(id);
    }
}
