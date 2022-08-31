package com.example.socialapp.mapper;

import com.example.socialapp.entity.Comment;
import com.example.socialapp.request.CommentCreateRequest;
import com.example.socialapp.request.CommentUpdateRequest;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper {

    CommentCreateRequest commentToCommentCreateRequest(Comment comment);
    CommentUpdateRequest commentToCommentUpdateRequest(Comment comment);

}
