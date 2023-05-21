package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.entities.Topic;
import com.openclassrooms.mddapi.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    public List<Topic> findAll(){
        return topicRepository.findAll();
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    public Topic findByTitle(String title) {
        return topicRepository.findByTitle(title).orElse(null);
    }
}
