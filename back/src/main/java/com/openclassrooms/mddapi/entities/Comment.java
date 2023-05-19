package com.openclassrooms.mddapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String content;
    @CreationTimestamp
    Date createdAt;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    User user;

}
