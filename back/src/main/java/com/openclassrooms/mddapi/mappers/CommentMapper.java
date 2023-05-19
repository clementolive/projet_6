package com.openclassrooms.mddapi.mappers;

import com.openclassrooms.mddapi.dtos.CommentDto;
import com.openclassrooms.mddapi.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target="author_name", expression="java(comment.getUser().getUsername())")
    CommentDto commentToCommentDto(Comment comment);

    @Mapping(target="author_name", expression="java(comment.getUser().getUsername())")
    CommentDto[] commentToCommentDtoArray(Comment[] comment);
}
