package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.TopicDto;
import com.openclassrooms.mddapi.entities.Topic;
import com.openclassrooms.mddapi.mappers.TopicMapper;
import com.openclassrooms.mddapi.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;

    @Autowired
    TopicMapper topicMapper;

    @GetMapping("/api/topic")
    public List<TopicDto> getTopics() {
        List<Topic> topicList = topicService.findAll();
        return topicMapper.topicToTopicDto(topicList);
    }

    /** Used inside the API only, the frontend sends the topicId to UserController (see unsubscribeToTopic)*/
    @GetMapping("/api/topic/{id}")
    public Topic getTopicById(@PathVariable("id") Long id){
        return topicService.findById(id);
    }


}
