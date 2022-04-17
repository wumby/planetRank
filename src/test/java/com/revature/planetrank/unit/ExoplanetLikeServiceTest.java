package com.revature.planetrank.unit;

import com.revature.planetrank.dao.ExoplanetLikeRepository;
import com.revature.planetrank.model.ExoplanetLikes;
import com.revature.planetrank.service.ExoplanetLikeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public class ExoplanetLikeServiceTest {
    private ExoplanetLikeService exoplanetLikeService;
    private ExoplanetLikeRepository exoplanetLikeRepository;

    private static ExoplanetLikes savedLike;

    @BeforeEach
    void setup() {
        exoplanetLikeRepository = createMockRepo();
        exoplanetLikeService = new ExoplanetLikeService(exoplanetLikeRepository);
    }

    @Test
    void testSaveLike(){
        ExoplanetLikes newLike = new ExoplanetLikes();
        newLike.setExoplanetLikeId(1);
        newLike.setExoplanetId(1);

        exoplanetLikeService.createLike(newLike);
        Integer actual = exoplanetLikeService.countLikesByExoplanetId(1);
        assertEquals(0,actual);
        assertEquals(savedLike.getExoplanetLikeId(), 1);
        assertEquals(savedLike.getExoplanetId(), 1);
    }

    public ExoplanetLikeRepository createMockRepo() {
        ExoplanetLikeRepository mockRepo = mock(ExoplanetLikeRepository.class);
        try {
            doAnswer(
                    (Answer<Void>) invocation -> {
                        savedLike = (ExoplanetLikes) invocation.getArguments()[0];
                        return null;
                    })
                    .when(mockRepo)
                    .save(any(ExoplanetLikes.class));
        } catch (Exception e) {
        }
        return mockRepo;
    }
}



