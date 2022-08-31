package com.example.socialapp.request;

import lombok.Data;

@Data
public class UserUpdateRequest {

    private String userName;
    private String fullName;
    private String password;
}
