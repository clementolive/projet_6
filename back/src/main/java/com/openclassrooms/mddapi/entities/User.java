package com.openclassrooms.mddapi.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USERS", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Data

@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = {"id"})

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Email
    private String email;

    @Size(max = 20)
    private String username;

    @Size(max = 120)
    private String password;

    @ManyToMany
    @JoinTable (name = "User_Theme_Association", joinColumns = {
            @JoinColumn(name = "id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "theme_id", referencedColumnName = "theme_id")}, uniqueConstraints = @UniqueConstraint(columnNames = {
            "id", "theme_id" }))
    List<Theme> themeList;

    public User(String email, String username, String encode) {
        this.email =   email;
        this.username = username;
        this.password = encode;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}