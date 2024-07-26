package com.example.employeetaskmanagement.repository;
import com.example.employeetaskmanagement.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
}