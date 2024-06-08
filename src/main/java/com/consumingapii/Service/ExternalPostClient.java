package com.consumingapii.Service;


import com.consumingapii.Config.postClientconfig;
import com.consumingapii.Models.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * Feign client for interacting with the external post API.
 */
@FeignClient(
        name = "${post-service.name}",
        url = "${post-service.url}",
        configuration = postClientconfig.class
)
public interface ExternalPostClient {
    @GetMapping("/posts")
    List<Post> fetchAllPosts();

    @GetMapping("/posts/{id}")
    Post fetchPostById(@PathVariable("id") Long id);

    @PostMapping("/posts")
    Post createPost(@RequestBody Post post);

    @PutMapping("/posts/{id}")
    Post updatePost(@PathVariable("id") Long id, @RequestBody Post post);

    @PatchMapping("/posts/{id}")
    Post partiallyUpdatePost(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates);

    @DeleteMapping("/posts/{id}")
    void deletePost(@PathVariable("id") Long id);
}
