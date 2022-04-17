package com.revature.planetrank.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exoplanets")
@NoArgsConstructor @Getter @Setter @ToString @AllArgsConstructor
public class Exoplanet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exoplanetId;

    @Column
    private String planetName;

    @Column
    private String hostName;

    @Column
    private int numberOfPlanets;

    @Column
    private int numberOfStars;

    @Column
    private int discoverYear;

    @Column
    private double planetMass;

    @Column
    private double distanceFromEarth;

    @Transient
    private int likeCount;

    @OneToMany(mappedBy = "exoplanetId")
    private List<ExoplanetComments> comments;

    @Column
    private String cardRank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exoplanet exoplanet = (Exoplanet) o;
        return exoplanetId == exoplanet.exoplanetId && numberOfPlanets == exoplanet.numberOfPlanets && numberOfStars == exoplanet.numberOfStars && discoverYear == exoplanet.discoverYear && Double.compare(exoplanet.planetMass, planetMass) == 0 && Double.compare(exoplanet.distanceFromEarth, distanceFromEarth) == 0 && likeCount == exoplanet.likeCount && Objects.equals(planetName, exoplanet.planetName) && Objects.equals(hostName, exoplanet.hostName) && Objects.equals(comments, exoplanet.comments) && Objects.equals(cardRank, exoplanet.cardRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exoplanetId, planetName, hostName, numberOfPlanets, numberOfStars, discoverYear,
                planetMass, distanceFromEarth, likeCount, comments, cardRank);
    }
}

