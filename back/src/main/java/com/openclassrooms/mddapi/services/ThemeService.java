package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {
    @Autowired
    ThemeRepository themeRepository;

    public List<Theme> findAll(){
        return themeRepository.findAll();
    }

    public Theme findById(Long id) {
        return themeRepository.findById(id).orElse(null);
    }

    public Theme findByTitle(String title) {
        return themeRepository.findByTitle(title).orElse(null);
    }
}
