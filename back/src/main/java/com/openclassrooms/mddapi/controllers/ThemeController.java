package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThemeController {

    @Autowired
    ThemeService themeService;

    @GetMapping("/api/theme")
    public Theme[] getThemes() {
        return themeService.findAll();
    }

    @GetMapping("/api/theme/{id}")
    public Theme getTheme(@PathVariable("id") Integer id){
        return themeService.findById(id);
    }
}
