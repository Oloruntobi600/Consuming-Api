package com.consumingapii.Storage;

import com.consumingapii.Models.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class PostStorage {
    private final List<Post> localPosts = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Post> getAllPosts() {
        return new ArrayList<>(localPosts);
    }

    public Post getPostById(Long id) {
        return localPosts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Post createPost(Post post) {
        post.setId(counter.incrementAndGet());
        localPosts.add(post);
        return post;
    }

    public Post updatePost(Long id, Post post) {
        Post existingPost = getPostById(id);
        if (existingPost == null) {
            return null;
        }
        existingPost.setTitle(post.getTitle());
        existingPost.setBody(post.getBody());
        return existingPost;
    }

    public boolean deletePost(Long id) {
        return localPosts.removeIf(post -> post.getId().equals(id));
    }
}

