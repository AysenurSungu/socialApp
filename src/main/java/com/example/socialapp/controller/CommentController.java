package com.example.socialapp.controller;


import com.example.socialapp.entity.Comment;
import com.example.socialapp.request.CommentCreateRequest;
import com.example.socialapp.request.CommentUpdateRequest;
import com.example.socialapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    @Autowired
    private final CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
                                        @RequestParam Optional<Long> postId){
        return commentService.findAllComments(userId,postId);
    }

    @PostMapping
    public Comment savePost(@RequestBody CommentCreateRequest comment){
        return commentService.save(comment);

    }

    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId){
        return commentService.findCommentById(commentId);
    }

    @PutMapping("/{postId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest updateComment){
        return commentService.updateCommentById(commentId, updateComment);
    }

    @DeleteMapping("/{userId}")
    public void deleteCommentById(@PathVariable Long commentId){
        commentService.deletePostById(commentId);
    }


}
