package com.example.socialapp.repository;

import com.example.socialapp.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    List<PostLike> findByUserIdAndPostId(Long userId, Long postId);

    List<PostLike> findByUserId(Long userId);

    List<PostLike> findByPostId(Long postId);
}
