package com.revature.planetrank.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exoplanet_likes")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class ExoplanetLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer exoplanetLikeId;
    private Integer userId;
    private Integer exoplanetId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExoplanetLikes that = (ExoplanetLikes) o;
        return Objects.equals(exoplanetLikeId, that.exoplanetLikeId) && Objects.equals(userId, that.userId) && Objects.equals(exoplanetId, that.exoplanetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exoplanetLikeId, userId, exoplanetId);
    }
}
