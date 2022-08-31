package com.example.socialapp.service;

import com.example.socialapp.entity.PostLike;
import com.example.socialapp.request.PostLikeCreateRequest;

import java.util.List;
import java.util.Optional;

public interface PostLikeService {

    List<PostLike> findAllPostLikes(Optional<Long> userId, Optional<Long> postId);

    PostLike save(PostLikeCreateRequest postLike);

    PostLike findPostLikeById(Long postLikeId);

    void deletePostLikeById(Long postLikeId);
}
