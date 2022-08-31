package com.example.socialapp.request;

import lombok.Data;

@Data
public class PostCreateRequest {

    private Long id;
    private String text;
    private String title;
    private Long userId;
}
