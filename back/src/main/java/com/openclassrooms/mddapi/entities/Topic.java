package com.openclassrooms.mddapi.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topic_id;
    private String title;
    private String description;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany( mappedBy = "topic",
            orphanRemoval = true)
    private List<Post> postList;

}
