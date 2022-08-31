package com.example.socialapp.mapper;

import com.example.socialapp.entity.User;
import com.example.socialapp.request.UserCreateRequest;
import com.example.socialapp.request.UserUpdateRequest;
import com.example.socialapp.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserUpdateRequest userToUserUpdateRequest(User user);
    UserCreateRequest userToUserCreateRequest(User user);
    User userResponseToUser(UserResponse userResponse);
}
