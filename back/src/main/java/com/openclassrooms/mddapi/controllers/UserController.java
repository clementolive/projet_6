package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.PostDto;
import com.openclassrooms.mddapi.entities.Post;
import com.openclassrooms.mddapi.entities.Topic;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.mappers.PostMapper;
import com.openclassrooms.mddapi.models.requests.UpdateUserRequest;
import com.openclassrooms.mddapi.models.response.MessageResponse;
import com.openclassrooms.mddapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** This Controller handles User (for profile page) but also subscriptions, because they are Mapped in User entity */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TopicController topicController;

    @Autowired
    private PostMapper postMapper;

    @PutMapping("/api/user/{id}")
    public MessageResponse updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequest req) {

        User current_user = userService.findById(id);
        current_user.setEmail(req.getEmail());
        current_user.setUsername(req.getUsername());
        userService.save(current_user);

        return new MessageResponse("User updated with success");
    }

    @GetMapping("/api/user/{id}/subscriptions")
    public List<Topic> getSubscriptions(@PathVariable("id") Long id){
        User user = userService.findById(id);

        return user.getTopicList();
    }

    @PostMapping("/api/user/{id}/subscribe/{topic_id}")
    public MessageResponse subscribeToTopic(@PathVariable("id") Long id, @PathVariable("topic_id") Long topic_id){
        User user = userService.findById(id);
        Topic topic = topicController.getTopicById(topic_id);
        user.getTopicList().add(topic);
        userService.save(user);

        return new MessageResponse("Subscribed to new topic");
    }

    @DeleteMapping("/api/user/{id}/unsubscribe/{topic_id}")
    public MessageResponse unsubscribeToTopic(@PathVariable("id") Long id, @PathVariable("topic_id") Long topic_id){
        User user = userService.findById(id);
        Topic topic = topicController.getTopicById(topic_id);
        user.getTopicList().remove(topic);
        userService.save(user);

        return new MessageResponse("Unsubscribed to topic");
    }

    @GetMapping("/api/user/{id}/isSubscribed/{topic_id}")
    public boolean isUserSubscribedToTopic(@PathVariable("id") Long id, @PathVariable("topic_id") Long topic_id){
        User user = userService.findById(id);
        Topic topic = topicController.getTopicById(topic_id);

        return user.getTopicList().contains(topic);
    }

    @GetMapping("/api/user/subscribedPosts/{id}")
    public List<PostDto> getSubscribedPosts(@PathVariable("id") Long id){
        User user = userService.findById(id);
        List<Topic> topicList = user.getTopicList();

        // Get all articles from subscribed topics in the same list
        List<Post> postList = new ArrayList<>();
        topicList.forEach(temp -> {
            postList.addAll(temp.getPostList());
        });

        // We convert to Dto
        List<PostDto> postDtoList = postMapper.postToPostDto(postList);

        // Sort by Date (more recent first)
        postDtoList.sort(Comparator.comparing(PostDto::getCreatedAt).reversed());

        return postDtoList;
    }
}
