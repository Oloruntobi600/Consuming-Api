//package com.consumingapii.Service;
//
//import com.consumingapii.Models.Post;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
//@FeignClient(name = "PostClient", url = "https://jsonplaceholder.typicode.com")
//public interface postClient {
//    @GetMapping("/posts")
//    List<Post> fetchAllPosts();
//
//    @GetMapping("/posts/{id}")
//    Post fetchPostById(@PathVariable("id") Long id);
//
//    @PostMapping("/posts")
//    Post createPost(@RequestBody Post post);
//
//    @PutMapping("/posts/{id}")
//    Post updatePost(@PathVariable("id") Long id, @RequestBody Post post);
//
//    @PatchMapping("/posts/{id}")
//    Post partiallyUpdatePost(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates);
//
//    @DeleteMapping("/posts/{id}")
//    void deletePost(@PathVariable("id") Long id);
//}
//
