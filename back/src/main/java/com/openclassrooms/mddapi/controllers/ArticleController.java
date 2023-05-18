package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.models.CreateArticleRequest;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import com.openclassrooms.mddapi.security.services.UserDetailsImpl;
import com.openclassrooms.mddapi.security.services.UserDetailsServiceImpl;
import com.openclassrooms.mddapi.services.ArticleService;
import com.openclassrooms.mddapi.services.ThemeService;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static java.rmi.server.LogStream.log;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ThemeService themeService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/api/article/{id}")
    public Article getArticle(@PathVariable("id") Integer id) {
        return articleService.getById(id);
    }

    @GetMapping("/api/article")
    public Article[] findAll() {
        return articleService.findAll();
    }

    @PostMapping("/api/article")
    public void createArticle(@RequestBody CreateArticleRequest req){
        Theme theme = themeService.findByTitle(req.getTheme());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Logger log = Logger.getAnonymousLogger();
        log(req.toString());
        User user = (User) userDetailsService.loadUserByUsername(currentPrincipalName);

        // =
        Article article = new Article(req.getTitle(), req.getContent(), theme, user);
        //Article test = new Article("news in Java", "Latest Java patch notes", theme, user );
        articleService.save(article);
    }

}
