package com.example.helloworld.service;

import com.example.helloworld.model.*;
import com.example.helloworld.repository.SwipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SwipeService {
    @Autowired
    private SwipeRepository swipeRepository;

    public Swipe swipe(User user, Post post, Swipe.SwipeDirection direction) {
        Optional<Swipe> existing = swipeRepository.findByUserAndPost(user, post);
        if (existing.isPresent()) {
            Swipe swipe = existing.get();
            swipe.setDirection(direction);
            return swipeRepository.save(swipe);
        }
        Swipe swipe = new Swipe();
        swipe.setUser(user);
        swipe.setPost(post);
        swipe.setDirection(direction);
        return swipeRepository.save(swipe);
    }

    public List<Swipe> getRightSwipedPosts(User user) {
        return swipeRepository.findByUserAndDirection(user, Swipe.SwipeDirection.RIGHT);
    }
}