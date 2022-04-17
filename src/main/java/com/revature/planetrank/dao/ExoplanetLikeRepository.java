package com.revature.planetrank.dao;

import com.revature.planetrank.model.ExoplanetLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExoplanetLikeRepository extends JpaRepository<ExoplanetLikes, Integer> {

    @Query("SELECT count(*) From ExoplanetLikes e where e.exoplanetId = :id")
    int countLikesByExoplanetId(@Param("id") Integer id);

}
