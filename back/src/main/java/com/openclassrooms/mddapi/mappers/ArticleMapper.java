package com.openclassrooms.mddapi.mappers;

import com.openclassrooms.mddapi.dtos.ArticleDto;
import com.openclassrooms.mddapi.entities.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    @Mapping(target="theme_name", expression="java(article.getTheme().getTitle())")
    @Mapping(target="author_name", expression="java(article.getUser().getUsername())")
    ArticleDto articleToArticleDto(Article article);
}
