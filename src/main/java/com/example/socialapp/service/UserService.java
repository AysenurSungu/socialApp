package com.example.socialapp.service;

import com.example.socialapp.entity.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);

    User findUserById(Long userId);

    User updateUserById(Long userId, User newUser);

    void deleteUserById(Long userId);


}
