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
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @Column(name="created_at")
    private Date createdAt;
    @JsonBackReference
    @NotNull
    @ManyToOne
    private Topic topic;

    @NotNull
    @JsonBackReference // Important even in one-directional relationship (error otherwise)
    @ManyToOne
    private User user;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL)
    @OrderColumn
    private List<Comment> comments;

    public Post(String title, String content, Topic topic, User user){
        this.title = title;
        this.content = content;
        this.topic = topic;
        this.user = user;
        this.createdAt = new Date();
    }

}
