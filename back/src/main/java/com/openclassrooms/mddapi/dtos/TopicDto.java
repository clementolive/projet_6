package com.openclassrooms.mddapi.dtos;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class TopicDto {

    Long topic_id;
    String title;
    String description;
    boolean subscribed;
}
