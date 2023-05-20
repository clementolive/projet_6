package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public Article getById(Long articleId){
        return articleRepository.getReferenceById(articleId);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public void save(Article article) {
        articleRepository.save(article);
    }
}
