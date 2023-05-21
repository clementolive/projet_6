package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.PostDto;
import com.openclassrooms.mddapi.entities.Post;
import com.openclassrooms.mddapi.entities.Comment;
import com.openclassrooms.mddapi.entities.Topic;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.mappers.PostMapper;
import com.openclassrooms.mddapi.mappers.CommentMapper;
import com.openclassrooms.mddapi.models.requests.CommentRequest;
import com.openclassrooms.mddapi.models.requests.CreatePostRequest;
import com.openclassrooms.mddapi.models.response.MessageResponse;
import com.openclassrooms.mddapi.security.services.UserDetailsServiceImpl;
import com.openclassrooms.mddapi.services.PostService;
import com.openclassrooms.mddapi.services.TopicService;
import com.openclassrooms.mddapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    TopicService topicService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserService userService;

    @Autowired
    PostMapper postMapper;

    @GetMapping("/api/post/{id}")
    public PostDto getPost(@PathVariable("id") Long id) {
        Post post =  postService.getById(id);
        return postMapper.postToPostDto(post);
    }

    @GetMapping("/api/post")
    public List<PostDto> findAll() {
        List<Post> posts = postService.findAll();
        return postMapper.postToPostDto(posts);
    }

    @PostMapping("/api/post")
    /** A new articles needs an author (user) and an associated Topic */
    public MessageResponse createPost(@RequestBody CreatePostRequest req){
        Topic topic = topicService.findByTitle(req.getTopic());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);

        User user = (User) userDetailsService.loadUserByUsername(currentPrincipalName);

        Post post = new Post(req.getTitle(), req.getContent(), topic, user);
        postService.save(post);

        return new MessageResponse("Post created");
    }

    @PostMapping("/api/post/{id}")
    public MessageResponse commentPost(@PathVariable("id") Long id, @RequestBody CommentRequest req) {

        // Create a comment from the request.
        Comment comment = new Comment();
        comment.setContent(req.getContent());

        // Binding current user to comment
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);

        User user = userService.findByEmail(currentPrincipalName);
        comment.setUser(user);

        // Binding in Post
        Post post =  postService.getById(id);
        post.getComments().add(comment);
        postService.save(post);

        return new MessageResponse("Comment added");
    }

}
