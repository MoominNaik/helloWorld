package com.example.helloworld.service;

import com.example.helloworld.model.ChatMessage;
import com.example.helloworld.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> master
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    // Save a new chat message
    public ChatMessage saveMessage(ChatMessage message) {
        if (message.getSender() == null || message.getSender().trim().isEmpty()) {
            throw new IllegalArgumentException("Sender cannot be null or empty");
        }
        if (message.getContent() == null || message.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be null or empty");
        }
<<<<<<< HEAD
        message.setTimestamp(LocalDateTime.now());
=======
    // timestamp removed
>>>>>>> master
        return chatMessageRepository.save(message);
    }

    // Get all messages
    public List<ChatMessage> getAllMessages() {
<<<<<<< HEAD
        return chatMessageRepository.findAllByOrderByTimestampDesc();
=======
    return chatMessageRepository.findAll();
>>>>>>> master
    }

    // Get message by ID
    public Optional<ChatMessage> getMessageById(Long id) {
        return chatMessageRepository.findById(id);
    }

    // Get messages by sender
    public List<ChatMessage> getMessagesBySender(String sender) {
<<<<<<< HEAD
        return chatMessageRepository.findBySenderOrderByTimestampDesc(sender);
=======
    return chatMessageRepository.findBySender(sender);
>>>>>>> master
    }

    // Get recent messages (last N messages)
    public List<ChatMessage> getRecentMessages(int limit) {
<<<<<<< HEAD
        List<ChatMessage> allMessages = chatMessageRepository.findAllByOrderByTimestampDesc();
        return allMessages.subList(0, Math.min(limit, allMessages.size()));
=======
    List<ChatMessage> allMessages = chatMessageRepository.findAll();
    return allMessages.subList(0, Math.min(limit, allMessages.size()));
>>>>>>> master
    }

    // Search messages by content
    public List<ChatMessage> searchMessages(String keyword) {
        return chatMessageRepository.findByContentContaining(keyword);
    }

    // Delete message by ID
    public boolean deleteMessage(Long id) {
        if (chatMessageRepository.existsById(id)) {
            chatMessageRepository.deleteById(id);
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    // Get messages after a specific timestamp
    public List<ChatMessage> getMessagesAfter(LocalDateTime timestamp) {
        return chatMessageRepository.findByTimestampAfter(timestamp);
    }
=======
    // Get messages after a specific timestamp (removed, no timestamp field)
>>>>>>> master
}
