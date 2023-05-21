package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.entities.Post;
import com.openclassrooms.mddapi.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post getById(Long articleId){
        return postRepository.getReferenceById(articleId);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void save(Post post) {
        postRepository.save(post);
    }
}
