package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.controllers.TopicController;
import com.openclassrooms.mddapi.dtos.TopicDto;
import com.openclassrooms.mddapi.entities.Topic;
import com.openclassrooms.mddapi.mappers.TopicMapper;
import com.openclassrooms.mddapi.services.TopicService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TopicControllerTest {

    @Mock
    private TopicService topicService;
    @InjectMocks
    TopicController topicController;
    @Spy
    private TopicMapper topicMapper;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void getTopics() {
        List<Topic> topicList = new ArrayList<>();
        when(topicService.findAll()).thenReturn(topicList);
        List<TopicDto> topicDtoList = topicMapper.topicToTopicDto(topicList);

        List<?> actual = topicController.getTopics();

        assertEquals(topicDtoList,actual);

        verify(topicService, times(1)).findAll();
        verifyNoMoreInteractions(topicService);
    }

    @Test
    void getById(){
        Topic topic = new Topic();
        when(topicService.findById(1L)).thenReturn(topic);

        Topic actual = topicController.getTopicById(1L);

        assertEquals(topic, actual);

        verify(topicService, times(1)).findById(1L);
        verifyNoMoreInteractions(topicService);
    }
}
