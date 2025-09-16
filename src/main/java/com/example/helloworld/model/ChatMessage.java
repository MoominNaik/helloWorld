package com.example.helloworld.model;

import jakarta.persistence.*;
<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> master

@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false, length = 1000)
    private String content;

<<<<<<< HEAD
    @Column(nullable = false)
    private LocalDateTime timestamp;

    // Default constructor
    public ChatMessage() {
        this.timestamp = LocalDateTime.now();
=======

    // Default constructor
    public ChatMessage() {
>>>>>>> master
    }

    // Constructor with parameters
    public ChatMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
<<<<<<< HEAD
        this.timestamp = LocalDateTime.now();
=======
>>>>>>> master
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

<<<<<<< HEAD
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
=======
>>>>>>> master

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", content='" + content + '\'' +
<<<<<<< HEAD
                ", timestamp=" + timestamp +
=======
>>>>>>> master
                '}';
    }
}
