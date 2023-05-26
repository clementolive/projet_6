package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dtos.PostDto;
import com.openclassrooms.mddapi.dtos.TopicDto;
import com.openclassrooms.mddapi.entities.Post;
import com.openclassrooms.mddapi.mappers.PostMapper;
import com.openclassrooms.mddapi.mappers.TopicMapper;
import com.openclassrooms.mddapi.services.PostService;
import com.openclassrooms.mddapi.services.TopicService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class PostControllerTest {


    @Mock
    private PostService postService;
    @InjectMocks
    PostController postController;
    @Spy
    private PostMapper postMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getPost() {
        Post post = new Post();

        when(postService.getById(1L)).thenReturn(post);
        PostDto postDto = postMapper.postToPostDto(post);

        PostDto actual = postController.getPost(1L);

        assertEquals(postDto,actual);

        verify(postService, times(1)).getById(1L);
        verifyNoMoreInteractions(postService);
    }

    @Test
    void findAll() {
    }

    @Test
    void createPost() {
    }

    @Test
    void commentPost() {
    }
}