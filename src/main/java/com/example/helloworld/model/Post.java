package com.example.helloworld.model;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String githubLink;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public Post() {}

    public Post(Long id, String content, String githubLink, User author) {
        this.id = id;
        this.content = content;
        this.githubLink = githubLink;
        this.author = author;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getGithubLink() { return githubLink; }
    public void setGithubLink(String githubLink) { this.githubLink = githubLink; }

    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }
}