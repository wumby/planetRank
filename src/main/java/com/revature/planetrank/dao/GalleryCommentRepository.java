package com.revature.planetrank.dao;

import com.revature.planetrank.model.GalleryComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GalleryCommentRepository extends JpaRepository<GalleryComments, String> {

    public abstract List<GalleryComments> findByNasaIdOrderByUploadDateDesc(String nasaId);



}
