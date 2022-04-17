package com.revature.planetrank.service;


import com.revature.planetrank.dao.ExoplanetRepository;
import com.revature.planetrank.model.Exoplanet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.util.List;

@Service
public class ExoplanetService {

    public static Logger log = LoggerFactory.getLogger(Driver.class);

    @Autowired
    private ExoplanetRepository exoplanetRepo;

    public List<Exoplanet> getAllExoplanets(){

        List<Exoplanet> exoplanetList = exoplanetRepo.findAll();

        log.info("Returned all exoplanets");
        return exoplanetList;

    }
}
