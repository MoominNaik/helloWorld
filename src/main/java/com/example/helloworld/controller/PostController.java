package com.example.helloworld.controller;

import com.example.helloworld.model.Post;
import com.example.helloworld.model.User;
import com.example.helloworld.service.PostService;
import com.example.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Post create(@RequestBody Post post, @RequestParam Long authorId) {
        User author = userService.findById(authorId).orElseThrow();
        post.setAuthor(author);
        return postService.create(post);
    }

    @GetMapping("/feed")
    public List<Post> feed() {
        return postService.findAll();
    }
}