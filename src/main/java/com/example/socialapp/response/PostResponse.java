package com.example.socialapp.response;

import lombok.Data;

@Data
public class PostResponse {
    private Long id;
    private Long userId;
    private String title;
    private String text;

}
