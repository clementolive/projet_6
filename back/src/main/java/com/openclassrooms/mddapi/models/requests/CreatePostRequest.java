package com.openclassrooms.mddapi.models.requests;

import lombok.Getter;

@Getter
public class CreatePostRequest {
    private String topic;
    private  String title;
    private String content;
}
