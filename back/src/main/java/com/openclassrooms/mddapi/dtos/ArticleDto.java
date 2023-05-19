package com.openclassrooms.mddapi.dtos;

import com.openclassrooms.mddapi.entities.Comment;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;

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
    Date createdAt;
    Comment[] comments;

}
