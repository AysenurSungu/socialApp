package com.example.socialapp.request;

import lombok.Data;

@Data
public class UserCreateRequest {

    private String userName;
    private String fullName;
    private String password;
}
