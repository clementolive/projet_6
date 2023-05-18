package com.openclassrooms.mddapi.dtos;

import com.openclassrooms.mddapi.entities.Comment;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
@Setter
public class ArticleDto {
    Long id;
    String title;
    String content;
    String theme_name;
    String author_name;
    Comment[] comments;

}
