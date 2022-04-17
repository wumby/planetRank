package com.revature.planetrank.unit;
import com.revature.planetrank.dao.ExoplanetRepository;
import com.revature.planetrank.model.Exoplanet;
import com.revature.planetrank.model.ExoplanetComments;
import com.revature.planetrank.service.ExoplanetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ExoplanetServiceTest {
    @Mock
    private ExoplanetRepository exoRepo;

    @InjectMocks
    private ExoplanetService exoService;



    @Test
    public void test_get_all_exoplanets(){
        ExoplanetComments fakecomment1 = new ExoplanetComments(1,"comment",1,1);
        ExoplanetComments fakecomment2 = new ExoplanetComments(2,"comment2",1,1);
        List<ExoplanetComments> fakeCommentList1= new ArrayList<>();
        List<ExoplanetComments> fakeCommentList2= new ArrayList<>();
        fakeCommentList1.add(fakecomment1);
        fakeCommentList2.add(fakecomment2);
        List<Exoplanet> fakeExoplanets = new ArrayList<>();
        fakeExoplanets.add(new Exoplanet(1,"planetname1","hostname1",1,1,1,1,1,1,fakeCommentList1,"rank"));
        fakeExoplanets.add(new Exoplanet(2,"planetname1","hostname1",1,1,1,1,1,1,fakeCommentList2,"rank"));


        when(exoRepo.findAll()).thenReturn(fakeExoplanets);


        List<Exoplanet> actualExoplanets = exoService.getAllExoplanets();
        Assertions.assertEquals(fakeExoplanets,actualExoplanets);
    }
}
