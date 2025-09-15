package com.example.helloworld.model;

import jakarta.persistence.*;

@Entity
@Table(name = "swipes")
public class Swipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    @Enumerated(EnumType.STRING)
    private SwipeDirection direction;

    public enum SwipeDirection {
        LEFT, RIGHT
    }

    public Swipe() {}

    public Swipe(Long id, User user, Post post, SwipeDirection direction) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.direction = direction;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }

    public SwipeDirection getDirection() { return direction; }
    public void setDirection(SwipeDirection direction) { this.direction = direction; }
}