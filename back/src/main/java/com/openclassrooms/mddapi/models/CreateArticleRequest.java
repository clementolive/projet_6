package com.openclassrooms.mddapi.models;

import lombok.Getter;

@Getter
public class CreateArticleRequest {
    String theme;
    String title;
    String content;
}
