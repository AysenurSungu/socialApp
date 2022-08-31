package com.example.socialapp.service;

import com.example.socialapp.entity.Post;
import com.example.socialapp.entity.PostLike;
import com.example.socialapp.entity.User;
import com.example.socialapp.repository.PostLikeRepository;
import com.example.socialapp.request.PostLikeCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostLikeServiceImpl implements PostLikeService{

    @Autowired
    private final PostLikeRepository postLikeRepository;

    @Autowired
    private final PostService postService;

    @Autowired
    private final UserService userService;



    @Override
    public List<PostLike> findAllPostLikes(Optional<Long> userId, Optional<Long> postId) {

        if(userId.isPresent() && postId.isPresent()){
            return postLikeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }
        else if(userId.isPresent()){
            return postLikeRepository.findByUserId(userId.get());
        }
        else if(postId.isPresent()){
            return postLikeRepository.findByPostId(postId.get());
        }
        else
            return postLikeRepository.findAll();

    }

    @Override
    public PostLike save(PostLikeCreateRequest postLike) {
        User user = userService.findUserById(postLike.getUserId());
        Post post = postService.findPostById(postLike.getPostId());

        if (user != null && post != null){
            PostLike postLikeToSave = new PostLike();
            postLikeToSave.setId(postLike.getId());
            postLikeToSave.setUser(user);
            postLikeToSave.setPost(post);
            return postLikeRepository.save(postLikeToSave);
        }
        else{
            return null;
        }
    }

    @Override
    public PostLike findPostLikeById(Long postLikeId) {
        return postLikeRepository.findById(postLikeId).orElse(null);
    }

    @Override
    public void deletePostLikeById(Long postLikeId) {
        postLikeRepository.deleteById(postLikeId);

    }
}
