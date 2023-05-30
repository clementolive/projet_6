package com.openclassrooms.mddapi.dtos;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class TopicDto {

    private Long topic_id;
    private String title;
    private String description;
    private boolean subscribed;
}
