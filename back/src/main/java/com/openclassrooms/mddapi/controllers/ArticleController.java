package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.ArticleDto;
import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.mappers.ArticleMapper;
import com.openclassrooms.mddapi.models.CreateArticleRequest;
import com.openclassrooms.mddapi.security.services.UserDetailsServiceImpl;
import com.openclassrooms.mddapi.services.ArticleService;
import com.openclassrooms.mddapi.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ThemeService themeService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    ArticleMapper articleMapper;

    @GetMapping("/api/article/{id}")
    public ArticleDto getArticle(@PathVariable("id") Long id) {

        Article article =  articleService.getById(id);
        return articleMapper.articleToArticleDto(article);
    }

    @GetMapping("/api/article")
    public ArticleDto[] findAll() {
        Article[] articles = articleService.findAll();
        return articleMapper.articleToArticleDto(articles);
    }

    @PostMapping("/api/article")
    /** A new articles needs an author (user) and an associated Theme) */
    public void createArticle(@RequestBody CreateArticleRequest req){
        Theme theme = themeService.findByTitle(req.getTheme());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = (User) userDetailsService.loadUserByUsername(currentPrincipalName);

        Article article = new Article(req.getTitle(), req.getContent(), theme, user);
        articleService.save(article);
    }

}
