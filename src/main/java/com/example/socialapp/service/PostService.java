package com.example.socialapp.service;

import com.example.socialapp.entity.Post;
import com.example.socialapp.request.PostCreateRequest;
import com.example.socialapp.request.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAllPosts(Optional<Long> userId);

    Post save(PostCreateRequest post);

    Post findPostById(Long postId);


    Post updatePostById(Long postId, PostUpdateRequest updatePost);

    void deletePostById(Long postId);
}
