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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** This is used to create posts, and also comment on them. */
@RestController
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostMapper postMapper;

    @GetMapping("/api/post/{id}")
    public PostDto getPost(@PathVariable("id") Long id) {
        Post post =  postService.getById(id);
        return postMapper.postToPostDto(post);
    }

    /** Not a part of features. Useful for testing */
    @GetMapping("/api/post")
    public List<PostDto> findAll() {
        List<Post> posts = postService.findAll();
        return postMapper.postToPostDto(posts);
    }

    /** A new article needs an author (user) and an associated Topic */
    @PostMapping("/api/post")
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

    /** A new comment must know its author (user) and we add the comment inside the comment list from a Post */
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
