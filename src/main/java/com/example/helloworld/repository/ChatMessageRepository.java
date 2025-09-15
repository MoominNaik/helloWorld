package com.example.helloworld.repository;

import com.example.helloworld.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    // Find messages by sender
    List<ChatMessage> findBySender(String sender);

    // Find messages by sender ordered by timestamp descending
    List<ChatMessage> findBySenderOrderByTimestampDesc(String sender);

    // Find messages after a specific timestamp
    List<ChatMessage> findByTimestampAfter(LocalDateTime timestamp);

    // Find messages between two timestamps
    List<ChatMessage> findByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);

    // Custom query to find messages containing specific text
    @Query("SELECT m FROM ChatMessage m WHERE LOWER(m.content) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<ChatMessage> findByContentContaining(@Param("keyword") String keyword);

    // Find all messages ordered by timestamp
    List<ChatMessage> findAllByOrderByTimestampDesc();
}
