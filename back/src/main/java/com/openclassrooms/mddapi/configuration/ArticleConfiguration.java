package com.openclassrooms.mddapi.configuration;

import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import java.util.Date;
import java.util.List;

@Configuration
public class ArticleConfiguration {

    @Bean
    @Order(1)
    CommandLineRunner articlesCommandLineRunner(ArticleRepository articleRepository){
        return args -> {
//            Article a1 = new Article(1, "Latest functions in SQL", "Lorem ipsum dolor sit amet, " +
//                    "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
//                    " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
//                    new Date());
//            Article a2 = new Article(2, "Latest functions in SQL", "Lorem ipsum dolor sit amet, " +
//                    "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
//                    " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
//                    new Date());
//            Article a3 = new Article(3, "Latest functions in CSS", "Lorem ipsum dolor sit amet, " +
//                    "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
//                    " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
//                    new Date());
//            Article a4 = new Article(4, "Latest news in CSS", "Lorem ipsum dolor sit amet, " +
//                    "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
//                    " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
//                    new Date());
//
//            articleRepository.saveAll(List.of(a1,a2,a3,a4));
        };
    }
}
