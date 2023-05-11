package com.openclassrooms.mddapi.models;

import com.openclassrooms.mddapi.entities.Theme;
import lombok.Data;

@Data
//Stores all themes in an array to display them in Theme page
public class ThemesResponse {
    Theme[] themes;

    public ThemesResponse(){
        themes = new Theme[30];
    }

}
