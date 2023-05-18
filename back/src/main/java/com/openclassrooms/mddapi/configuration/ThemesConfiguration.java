package com.openclassrooms.mddapi.configuration;

import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import com.openclassrooms.mddapi.security.services.UserDetailsImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class ThemesConfiguration {

    @Bean
    @Order(2)
    CommandLineRunner themesCommandLineRunner(ThemeRepository themeRepository){
        return args -> {
            Article a1 = new Article(1, "Latest functions in SQL", "Lorem ipsum dolor sit amet, " +
                    "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                    " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    new Date(), new Theme(), new User());
            Article a2 = new Article(2, "Latest news in SQL", "Lorem ipsum dolor sit amet, " +
                    "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                    " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    new Date(), new Theme(), new User());
            List<Article> articleList = List.of(a1,a2);

            Theme t1 = new Theme(1, "SQL", "News about SQL language", articleList);
            a1.setTheme(t1);
            a2.setTheme(t1);

            themeRepository.saveAll(List.of(t1));
        };
    }
}

