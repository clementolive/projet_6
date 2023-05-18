package com.openclassrooms.mddapi.models.requests;

import lombok.Getter;

@Getter
public class CreateArticleRequest {
    String theme;
    String title;
    String content;
}
