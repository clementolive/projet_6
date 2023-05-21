package com.openclassrooms.mddapi.mappers;

import com.openclassrooms.mddapi.dtos.ThemeDto;
import com.openclassrooms.mddapi.entities.Theme;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeMapper {

    ThemeDto themeToThemeDto (Theme theme);

    List<ThemeDto> themeToThemeDto (List<Theme> theme);
}
