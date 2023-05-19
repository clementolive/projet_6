package com.openclassrooms.mddapi.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {
    String content;

    String author_name;

}
