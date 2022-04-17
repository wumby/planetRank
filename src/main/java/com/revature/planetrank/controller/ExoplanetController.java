package com.revature.planetrank.controller;


import com.revature.planetrank.model.Exoplanet;
import com.revature.planetrank.model.ExoplanetComments;
import com.revature.planetrank.service.ExoplanetLikeService;
import com.revature.planetrank.service.ExoplanetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Driver;
import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*", exposedHeaders = "*", allowedHeaders = "*")
public class ExoplanetController {

    public static Logger log = LoggerFactory.getLogger(Driver.class);

    @Autowired
    private ExoplanetService exoplanetService;

    @Autowired
    private ExoplanetLikeService exoplanetLikeService;

    @GetMapping("/exoplanets")
    public List<Exoplanet> getExoplanets(){

        List<Exoplanet> exoplanetList = exoplanetService.getAllExoplanets();
        for (Exoplanet e: exoplanetList){
            e.setLikeCount(exoplanetLikeService.countLikesByExoplanetId(e.getExoplanetId()));
        }

        log.info("All Exoplanets have been returned [Controller Layer]");
        return exoplanetList;
    }

    @PostMapping("/comments")
    @ResponseBody
    public ExoplanetComments postExoplanetComment() {


        return null;
    }
}
