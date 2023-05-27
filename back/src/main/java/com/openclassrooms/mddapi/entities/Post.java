package com.openclassrooms.mddapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    String title;
    @NotBlank
    String content;
    @Column(name="created_at")
    Date createdAt;
    @JsonBackReference
    @NotNull
    @ManyToOne
    Topic topic;

    @NotNull
    @JsonBackReference // Important even in one-directional relationship (error otherwise)
    @ManyToOne
    User user;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    List<Comment> comments;

    public Post(String title, String content, Topic topic, User user){
        this.title = title;
        this.content = content;
        this.topic = topic;
        this.user = user;
        this.createdAt = new Date();
    }

}
