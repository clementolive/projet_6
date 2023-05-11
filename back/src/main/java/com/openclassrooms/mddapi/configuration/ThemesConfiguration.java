package com.openclassrooms.mddapi.configuration;

import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ThemesConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(ThemeRepository themeRepository){
        return args -> {
            Theme t1 = new Theme(1, "SQL", "News about SQL language");
            Theme t2 = new Theme(2, "Java", "News about Java language");
            Theme t3 = new Theme(3, "C++", "News about C++ language");

            themeRepository.saveAll(List.of(t1, t2, t3));
        };
    }
}

