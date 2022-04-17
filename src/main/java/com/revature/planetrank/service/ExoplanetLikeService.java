package com.revature.planetrank.service;

import com.revature.planetrank.dao.ExoplanetLikeRepository;
import com.revature.planetrank.model.ExoplanetLikes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExoplanetLikeService {

    public ExoplanetLikeService(final ExoplanetLikeRepository exoplanetLikeRepository) {
        this.exoplanetLikeRepository = exoplanetLikeRepository;
    }

    public final ExoplanetLikeRepository exoplanetLikeRepository;

    public ExoplanetLikes createLike( ExoplanetLikes like){
        return exoplanetLikeRepository.save(like);
    }

    public int countLikesByExoplanetId(Integer id){
        return exoplanetLikeRepository.countLikesByExoplanetId(id);

    }

}
