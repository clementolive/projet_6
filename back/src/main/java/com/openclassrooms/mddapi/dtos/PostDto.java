package com.openclassrooms.mddapi.dtos;

import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class PostDto {
    private Long id;
    private String title;
    private  String content;
    private String topic_name;
    private String author_name;
    private Date createdAt;
    private List<CommentDto> comments;

}
