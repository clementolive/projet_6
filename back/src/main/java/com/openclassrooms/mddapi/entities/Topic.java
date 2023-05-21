package com.openclassrooms.mddapi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long topic_id;
    String title;
    String description;

    @JsonManagedReference
    @OneToMany( mappedBy = "topic", fetch = FetchType.LAZY,
            orphanRemoval = true)
    List<Post> postList;

}
