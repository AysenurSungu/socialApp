package com.example.socialapp.service;

import com.example.socialapp.entity.Post;
import com.example.socialapp.entity.User;
import com.example.socialapp.repository.PostRepository;
import com.example.socialapp.request.PostCreateRequest;
import com.example.socialapp.request.PostUpdateRequest;
import com.example.socialapp.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    private final UserService userService;

    @Override
    public List<Post> findAllPosts(Optional<Long> userId) {
        if(userId.isPresent()){
            postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    @Override
    public Post save(PostCreateRequest post) {
        User user = userService.findUserById(post.getUserId());
        if(user == null){
            return null;
        }
        Post postToSave = new Post();
        postToSave.setId(post.getId());
        postToSave.setText(post.getText());
        postToSave.setTitle(post.getTitle());
        postToSave.setUser(user);
        return postRepository.save(postToSave);
    }

    @Override
    public Post findPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post updatePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setTitle(updatePost.getTitle());
            toUpdate.setText(updatePost.getText());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }


}
