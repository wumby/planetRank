package com.revature.planetrank.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
@NoArgsConstructor @Getter @Setter @ToString @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "users_username", nullable = false, unique = true)
    private String username;

    @Column(name = "users_password")
    private String password;

    @JoinColumn(columnDefinition = "varchar(255) default 'member'")
    @ManyToOne
    private UserRole role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password);
    }

}
