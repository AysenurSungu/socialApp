package com.example.socialapp.service;

import com.example.socialapp.entity.Comment;
import com.example.socialapp.entity.Post;
import com.example.socialapp.entity.User;
import com.example.socialapp.repository.CommentRepository;
import com.example.socialapp.request.CommentCreateRequest;
import com.example.socialapp.request.CommentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    @Autowired
    private final CommentRepository commentRepository;

    @Autowired
    private final PostService postService;

    @Autowired
    private final UserService userService;


    @Override
    public List<Comment> findAllComments(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }
        else if(userId.isPresent()){
            return commentRepository.findByUserId(userId.get());
        }
        else if(postId.isPresent()){
            return commentRepository.findByPostId(postId.get());
        }
        else
            return commentRepository.findAll();
    }

    @Override
    public Comment save(CommentCreateRequest comment) {
        User user = userService.findUserById(comment.getUserId());
        Post post = postService.findPostById(comment.getPostId());

        if (user != null && post != null){
            Comment commentToSave = new Comment();
            commentToSave.setId(comment.getId());
            commentToSave.setUser(user);
            commentToSave.setPost(post);
            commentToSave.setText(commentToSave.getText());

            return commentRepository.save(commentToSave);
        }
        else{
            return null;
        }

    }

    @Override
    public Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public Comment updateCommentById(Long commentId, CommentUpdateRequest updateComment) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(updateComment.getText());

            return commentRepository.save(commentToUpdate);
        }
        else{
            return null;
        }

    }

    @Override
    public void deletePostById(Long commentId) {
        commentRepository.deleteById(commentId);

    }




}
