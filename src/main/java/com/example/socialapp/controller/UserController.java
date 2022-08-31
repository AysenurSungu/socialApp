package com.example.socialapp.controller;

import com.example.socialapp.entity.User;
import com.example.socialapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        //custom excepion
        return userService.findUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateUserById(@PathVariable Long userId, @RequestBody User newUser ){
        return userService.updateUserById(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
    }

}
