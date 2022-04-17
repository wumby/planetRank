package com.revature.planetrank.service;

import com.revature.planetrank.dao.ExoplanetCommentRepository;
import com.revature.planetrank.model.ExoplanetComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExoplanetCommentService {

    public ExoplanetCommentService(final ExoplanetCommentRepository exoplanetCommentRepository) {
        this.exoplanetCommentRepository = exoplanetCommentRepository;
    }

    public final ExoplanetCommentRepository exoplanetCommentRepository;

    public ExoplanetComments createComment(ExoplanetComments comment){

        return exoplanetCommentRepository.save(comment);
    }
}
