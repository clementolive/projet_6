package com.openclassrooms.mddapi.mappers;

import com.openclassrooms.mddapi.dtos.ArticleDto;
import com.openclassrooms.mddapi.entities.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ArticleMapper {

    public CommentMapper commentMapper;

    @Autowired
    public final void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Mapping(target="theme_name", expression="java(article.getTheme().getTitle())")
    @Mapping(target="author_name", expression="java(article.getUser().getUsername())")
    @Mapping(target="createdAt", expression="java(article.getCreatedAt())")
    @Mapping(target="comments", expression="java(commentMapper.commentToCommentDtoArray(article.getComments()))")
    public abstract ArticleDto articleToArticleDto(Article article);

    @Mapping(target="theme_name", expression="java(article.getTheme().getTitle())")
    @Mapping(target="author_name", expression="java(article.getUser().getUsername())")
    @Mapping(target="createdAt", expression="java(article.getCreatedAt())")
    @Mapping(target="comments", expression="java(commentMapper.commentToCommentDtoArray(article.getComments()))")
    public abstract List<ArticleDto> articleToArticleDto(List<Article> article);

    public void fun(){}
}
