package com.example.socialapp.controller;

import com.example.socialapp.entity.PostLike;
import com.example.socialapp.request.PostLikeCreateRequest;
import com.example.socialapp.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postsLikes")
@RequiredArgsConstructor
public class PostLikeController {
    @Autowired
    private final PostLikeService postLikeService;

    @GetMapping
    public List<PostLike> getAllPostLikes(@RequestParam Optional<Long> userId,
                                        @RequestParam Optional<Long> postId){
        return postLikeService.findAllPostLikes(userId, postId);
    }

    @PostMapping
    public PostLike savePostLike(@RequestBody PostLikeCreateRequest postLike){
        return postLikeService.save(postLike);

    }

    @GetMapping("/{commentId}")
    public PostLike getPostLikeById(@PathVariable Long postLikeId){
        return postLikeService.findPostLikeById(postLikeId);
    }


    @DeleteMapping("/{userId}")
    public void deletePostLikeById(@PathVariable Long postLikeId){
        postLikeService.deletePostLikeById(postLikeId);
    }

}
