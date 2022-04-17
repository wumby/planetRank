package com.revature.planetrank.integration;


import com.revature.planetrank.dao.ExoplanetRepository;
import com.revature.planetrank.model.Exoplanet;
import com.revature.planetrank.model.ExoplanetComments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Profile("test")
public class ExoplanetRepositoryTest {

    @Autowired
    ExoplanetRepository exoRepo;

    @Test
    @Transactional
    public void find_all_exoplanets_test(){
        List<Exoplanet> actualExoplanets = exoRepo.findAll();

        ExoplanetComments fakecomment1 = new ExoplanetComments(1,"comment",1,1);
        List<ExoplanetComments> fakeCommentList1= new ArrayList<>();
        List<ExoplanetComments> fakeCommentList2= new ArrayList<>();
        fakeCommentList1.add(fakecomment1);

        Exoplanet fakeExo = new Exoplanet();
        fakeExo.setCardRank("Bronze");
        fakeExo.setDiscoverYear(2020);
        fakeExo.setDistanceFromEarth(31.7);
        fakeExo.setPlanetMass(17);
        fakeExo.setPlanetName("AU Mic b");
        fakeExo.setExoplanetId(1);
        fakeExo.setHostName("AU Mic");
        fakeExo.setNumberOfStars(1);
        fakeExo.setComments(fakeCommentList2);
        fakeExo.setNumberOfPlanets(2);



        Assertions.assertEquals(fakeExo,actualExoplanets.get(0));

    }
}

