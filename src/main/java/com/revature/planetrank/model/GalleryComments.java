package com.revature.planetrank.model;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gallery_comments")
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class GalleryComments {
    @Id
    @Column(name="image_comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int galleryCommentId;

    @Column(name = "image_comment")
    private String comment;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name="nasa_id")
    private String nasaId ;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "upload_date", nullable = false)
    private Date uploadDate;

    @PrePersist
    private void onCreate() {
        uploadDate = new Date();
    }

}
