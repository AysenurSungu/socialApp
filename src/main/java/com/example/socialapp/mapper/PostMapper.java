package com.example.socialapp.mapper;

import com.example.socialapp.entity.Post;
import com.example.socialapp.request.PostCreateRequest;
import com.example.socialapp.request.PostUpdateRequest;
import com.example.socialapp.response.PostResponse;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {
    PostCreateRequest postToPostCreateRequest(Post post);
    PostUpdateRequest postToPostUpdateRequest(Post post);
    Post postResponseToPost(PostResponse postResponse);
}
