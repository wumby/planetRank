package com.revature.planetrank.dao;

import com.revature.planetrank.model.ExoplanetComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExoplanetCommentRepository extends JpaRepository<ExoplanetComments, Integer> {
}
