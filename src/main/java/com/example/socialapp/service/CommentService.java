package com.example.socialapp.service;

import com.example.socialapp.entity.Comment;
import com.example.socialapp.entity.Post;
import com.example.socialapp.request.CommentCreateRequest;
import com.example.socialapp.request.CommentUpdateRequest;
import com.example.socialapp.request.PostCreateRequest;
import com.example.socialapp.request.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> findAllComments(Optional<Long> userId, Optional<Long> postId);

    Comment findCommentById(Long commentId);

    Comment save(CommentCreateRequest comment);

    Comment updateCommentById(Long commentId, CommentUpdateRequest updateComment);

    void deletePostById(Long commentId);
}
