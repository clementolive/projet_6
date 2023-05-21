package com.openclassrooms.mddapi.models.requests;

import lombok.Getter;

@Getter
public class CreatePostRequest {
    String topic;
    String title;
    String content;
}
