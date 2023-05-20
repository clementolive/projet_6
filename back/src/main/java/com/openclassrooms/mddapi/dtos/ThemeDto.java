package com.openclassrooms.mddapi.dtos;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class ThemeDto {

    Long theme_id;
    String title;
    String description;
    boolean subscribed;
}
