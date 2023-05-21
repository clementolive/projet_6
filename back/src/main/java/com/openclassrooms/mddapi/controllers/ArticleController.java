package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.ArticleDto;
import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.entities.Comment;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.mappers.ArticleMapper;
import com.openclassrooms.mddapi.mappers.CommentMapper;
import com.openclassrooms.mddapi.models.requests.CommentRequest;
import com.openclassrooms.mddapi.models.requests.CreateArticleRequest;
import com.openclassrooms.mddapi.models.response.MessageResponse;
import com.openclassrooms.mddapi.security.services.UserDetailsServiceImpl;
import com.openclassrooms.mddapi.services.ArticleService;
import com.openclassrooms.mddapi.services.ThemeService;
import com.openclassrooms.mddapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ThemeService themeService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserService userService;

    @Autowired
    ArticleMapper articleMapper;

    @GetMapping("/api/article/{id}")
    public ArticleDto getArticle(@PathVariable("id") Long id) {
        Article article =  articleService.getById(id);
        return articleMapper.articleToArticleDto(article);
    }

    @GetMapping("/api/article")
    public List<ArticleDto> findAll() {
        List<Article> articles = articleService.findAll();
        return articleMapper.articleToArticleDto(articles);
    }

    @PostMapping("/api/article")
    /** A new articles needs an author (user) and an associated Theme */
    public MessageResponse createArticle(@RequestBody CreateArticleRequest req){
        Theme theme = themeService.findByTitle(req.getTheme());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);

        User user = (User) userDetailsService.loadUserByUsername(currentPrincipalName);

        Article article = new Article(req.getTitle(), req.getContent(), theme, user);
        articleService.save(article);

        return new MessageResponse("Article created");
    }

    @PostMapping("/api/article/{id}")
    public MessageResponse commentArticle(@PathVariable("id") Long id, @RequestBody CommentRequest req) {

        // Create a comment from the request.
        Comment comment = new Comment();
        comment.setContent(req.getContent());

        // Binding current user to comment
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        //User user = (User) userDetailsService.loadUserByUsername(currentPrincipalName);
        User user = userService.findByEmail(currentPrincipalName);
        comment.setUser(user);

        // Binding in Article
        Article article =  articleService.getById(id);
        article.getComments().add(comment);
        articleService.save(article);

        return new MessageResponse("Comment added");
    }

}
