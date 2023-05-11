package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.models.ThemesResponse;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeService {
    @Autowired
    ThemeRepository themeRepository;

    public ThemesResponse findAll(){
        ThemesResponse themesResponse = new ThemesResponse();
        Theme[] themeList = themeRepository.findAll().toArray(new Theme[0]);
        themesResponse.setThemes(themeList);
        return themesResponse;
    }

}
