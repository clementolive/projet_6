package com.openclassrooms.mddapi.mappers;

import com.openclassrooms.mddapi.dtos.CommentDto;
import com.openclassrooms.mddapi.dtos.PostDto;
import com.openclassrooms.mddapi.entities.Comment;
import com.openclassrooms.mddapi.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/** This mapper gets a commentDto list and set it in PostDto to simplify JSON data */
@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Mapping(target="topic_name", source="post.topic.title")
    @Mapping(target="author_name", source="post.user.username")
    @Mapping(target="createdAt", source="post.createdAt")
    @Mapping(target="comments", source="post.comments")
    public abstract PostDto postToPostDto(Post post);

    @Mapping(target="topic_name", source="post.topic.title")
    @Mapping(target="author_name", source="post.user.username")
    @Mapping(target="createdAt", source="post.createdAt")
    @Mapping(target="comments", source="post.comments")
    public abstract List<PostDto> postToPostDto(List<Post> post);

    @Mapping(target="author_name", source="comment.user.username")
    public abstract CommentDto commentToCommentDto(Comment comment);

    @Mapping(target="author_name", source="comment.user.username")
    public abstract List<CommentDto> commentToCommentDtoArray(List<Comment> comment);

    //This allows use of abstract class, which is needed for adding nested Mappers
    public void fun(){}
}
