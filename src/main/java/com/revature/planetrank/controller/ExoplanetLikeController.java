package com.revature.planetrank.controller;

import com.revature.planetrank.model.Exoplanet;
import com.revature.planetrank.model.ExoplanetLikes;
import com.revature.planetrank.service.ExoplanetLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", exposedHeaders = "*", allowedHeaders = "*")
public class ExoplanetLikeController {

    @Autowired
    private ExoplanetLikeService exoplanetLikeService;

    @PostMapping("/like")
    public ExoplanetLikes addlike(@RequestBody ExoplanetLikes like){
        return exoplanetLikeService.createLike(like);
    }


}
