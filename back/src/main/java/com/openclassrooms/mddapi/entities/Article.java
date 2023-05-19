package com.openclassrooms.mddapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Article {
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
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    Theme theme;
    @JsonBackReference
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    User user;
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @OrderColumn
    Comment[] comments;

    public Article(String title, String content, Theme theme, User user){
        this.title = title;
        this.content = content;
        this.theme = theme;
        this.user = user;
        this.createdAt = new Date();
    }

}
