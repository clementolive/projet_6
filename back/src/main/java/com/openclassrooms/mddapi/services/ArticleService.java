package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public Article getById(Integer articleId){
        return articleRepository.getReferenceById(Long.valueOf(articleId));
    }

    public Article[] findAll() {
        return articleRepository.findAll().toArray(new Article[0]);
    }

    public void save(Article article) {
        articleRepository.save(article);
    }
}
