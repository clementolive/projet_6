package com.openclassrooms.mddapi.mappers;

import com.openclassrooms.mddapi.dtos.PostDto;
import com.openclassrooms.mddapi.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/** This mapper gets a commentDto list and set it in PostDto to simplify JSON data */
@Mapper(componentModel = "spring")
public abstract class PostMapper {

    public CommentMapper commentMapper;

    @Autowired
    public final void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Mapping(target="topic_name", expression="java(post.getTopic().getTitle())")
    @Mapping(target="author_name", expression="java(post.getUser().getUsername())")
    @Mapping(target="createdAt", expression="java(post.getCreatedAt())")
    @Mapping(target="comments", expression="java(commentMapper.commentToCommentDtoArray(post.getComments()))")
    public abstract PostDto postToPostDto(Post post);

    @Mapping(target="topic_name", expression="java(post.getTopic().getTitle())")
    @Mapping(target="author_name", expression="java(post.getUser().getUsername())")
    @Mapping(target="createdAt", expression="java(post.getCreatedAt())")
    @Mapping(target="comments", expression="java(commentMapper.commentToCommentDtoArray(post.getComments()))")
    public abstract List<PostDto> postToPostDto(List<Post> post);

    //This allows use of abstract class, which is needed for adding nested Mappers
    public void fun(){}
}
