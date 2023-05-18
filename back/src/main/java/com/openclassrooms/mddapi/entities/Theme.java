package com.openclassrooms.mddapi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long theme_id;
    String title;
    String description;

    @JsonManagedReference
    @OneToMany( mappedBy = "theme",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Article> articleList;

}
