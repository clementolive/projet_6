package com.openclassrooms.mddapi.dtos;

import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class ArticleDto {
    Long id;
    String title;
    String content;
    String theme_name;
    String author_name;
    Date createdAt;
    List<CommentDto> comments;

}
