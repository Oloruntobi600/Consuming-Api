package com.consumingapii.Service;

import com.consumingapii.Models.Post;
import com.consumingapii.Storage.PostStorage;
import feign.FeignException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostStorage postStorage;
    private final ExternalPostClient externalPostClient;

    public PostService(PostStorage postStorage, ExternalPostClient externalPostClient) {
        this.postStorage = postStorage;
        this.externalPostClient = externalPostClient;
    }

    public List<Post> getAllPosts() {
        List<Post> localPosts = postStorage.getAllPosts();
        List<Post> externalPosts = externalPostClient.fetchAllPosts();
        externalPosts.addAll(localPosts);
        return externalPosts;
    }

    public Optional<Post> getPostById(Long id) {
        Post post = postStorage.getPostById(id);
        if (post == null) {
            try {
                post = externalPostClient.fetchPostById(id);
            } catch (FeignException.NotFound e) {
                return Optional.empty();
            }
        }
        return Optional.ofNullable(post);
    }

    public Post createPost(Post post) {
        return postStorage.createPost(post);
    }

    public Post updatePost(Long id, Post post) {
        return postStorage.updatePost(id, post);
    }

    public boolean deletePost(Long id) {
        return postStorage.deletePost(id);
    }
}



