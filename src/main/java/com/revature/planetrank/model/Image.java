package com.revature.planetrank.model;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "gallery_images")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @ToString
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nasa_id")
    private String nasaId;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="description", columnDefinition = "TEXT")
    private String description;

    @Column(name="date_created")
    private Date dateCreated;

    @Column(name="thumb_url")
    private String thumbUrl;

    @Column(name="large_url")
    private String largeUrl;

    @Column(name="orig_url")
    private String origUrl;


}
