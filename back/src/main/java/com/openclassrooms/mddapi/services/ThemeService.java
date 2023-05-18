package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThemeService {
    @Autowired
    ThemeRepository themeRepository;

    public Theme[] findAll(){
        Theme[] themeList = themeRepository.findAll().toArray(new Theme[0]);
        return themeList;
    }

    public Theme findById(Integer id) {
        return themeRepository.findById(Long.valueOf(id)).orElse(null);
    }

    public Theme findByTitle(String title) {
        return themeRepository.findByTitle(title).orElse(null);
    }
}
