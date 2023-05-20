package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.ThemeDto;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.mappers.ThemeMapper;
import com.openclassrooms.mddapi.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThemeController {

    @Autowired
    ThemeService themeService;

    @Autowired
    ThemeMapper themeMapper;

    @GetMapping("/api/theme")
    public List<ThemeDto> getThemes() {
        List<Theme> themeList = themeService.findAll();
        return themeMapper.themeToThemeDto(themeList);
    }

    @GetMapping("/api/theme/{id}")
    public Theme getThemeById(@PathVariable("id") Long id){
        return themeService.findById(id);
    }

    @GetMapping("/api/theme/{title}")
    public Theme getThemeByTitle(@PathVariable("title") String title){
        return themeService.findByTitle(title);
    }


}
