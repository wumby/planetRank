package com.revature.planetrank.dao;

import com.revature.planetrank.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findByNasaId(String nasaId);
    List<Image> findById(int id);

}
