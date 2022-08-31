package com.example.socialapp.controller;

import com.example.socialapp.entity.Post;
import com.example.socialapp.request.PostCreateRequest;
import com.example.socialapp.request.PostUpdateRequest;
import com.example.socialapp.response.PostResponse;
import com.example.socialapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {


    @Autowired
    private final PostService postService;



    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.findAllPosts(userId);
    }

    @PostMapping
    public Post savePost(@RequestBody PostCreateRequest post){
        return postService.save(post);

    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.findPostById(postId);
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost){
        return postService.updatePostById(postId, updatePost);
    }

    @DeleteMapping("/{userId}")
    public void deletePostById(@PathVariable Long postId){
        postService.deletePostById(postId);
    }

}
