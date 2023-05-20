package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.models.requests.UpdateUserRequest;
import com.openclassrooms.mddapi.models.response.MessageResponse;
import com.openclassrooms.mddapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ThemeController themeController;

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
}
