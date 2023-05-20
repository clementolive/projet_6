package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.ArticleDto;
import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.mappers.ArticleMapper;
import com.openclassrooms.mddapi.models.requests.UpdateUserRequest;
import com.openclassrooms.mddapi.models.response.MessageResponse;
import com.openclassrooms.mddapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ThemeController themeController;

    @Autowired
    ArticleMapper articleMapper;

    @PutMapping("/api/user/{id}")
    public MessageResponse updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequest req) {

        User current_user = userService.findById(id);
        current_user.setEmail(req.getEmail());
        current_user.setUsername(req.getUsername());
        userService.save(current_user);

        return new MessageResponse("User updated with success");
    }

    @GetMapping("/api/user/{id}/subscriptions")
    public List<Theme> getSubscriptions(@PathVariable("id") Long id){
        User user = userService.findById(id);

        return user.getThemeList();
    }

    @PostMapping("/api/user/{id}/subscribe/{theme_id}")
    public MessageResponse subscribeToTheme(@PathVariable("id") Long id, @PathVariable("theme_id") Long theme_id){
        User user = userService.findById(id);
        Theme theme = themeController.getThemeById(theme_id);
        user.getThemeList().add(theme);
        userService.save(user);

        return new MessageResponse("Subscribed to new theme");
    }

    @PostMapping("/api/user/{id}/unsubscribe/{theme_id}")
    public MessageResponse unsubscribeToTheme(@PathVariable("id") Long id, @PathVariable("theme_id") Long theme_id){
        User user = userService.findById(id);
        Theme theme = themeController.getThemeById(theme_id);
        user.getThemeList().remove(theme);
        userService.save(user);

        return new MessageResponse("Unsubscribed to theme");
    }

    @GetMapping("/api/user/{id}/isSubscribed/{theme_id}")
    public boolean isUserSubscribedToTheme(@PathVariable("id") Long id, @PathVariable("theme_id") Long theme_id){
        User user = userService.findById(id);
        Theme theme = themeController.getThemeById(theme_id);

        return user.getThemeList().contains(theme);
    }

    @GetMapping("/api/user/subscribedArticles/{id}")
    public List<ArticleDto> getSubscribedArticles(@PathVariable("id") Long id){
        User user = userService.findById(id);
        List<Theme> themeList = user.getThemeList();

        // Get all articles from subscribed themes in the same list
        List<Article> articleList = new ArrayList<>();
        themeList.forEach(temp -> {
            articleList.addAll(temp.getArticleList());
        });

        // We convert to Dto
        List<ArticleDto> articleDtoList = articleMapper.articleToArticleDto(articleList);

        // Sort by Date (more recent first)
        articleDtoList.sort(Comparator.comparing(ArticleDto::getCreatedAt).reversed());

        return articleDtoList;
    }
}
