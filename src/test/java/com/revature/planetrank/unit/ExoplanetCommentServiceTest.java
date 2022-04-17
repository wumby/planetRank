package com.revature.planetrank.unit;

import com.revature.planetrank.dao.ExoplanetCommentRepository;
import com.revature.planetrank.model.ExoplanetComments;
import com.revature.planetrank.service.ExoplanetCommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public class ExoplanetCommentServiceTest {
    private ExoplanetCommentService exoplanetCommentService;
    private ExoplanetCommentRepository exoplanetCommentRepository;

    private static ExoplanetComments savedComment;

    @BeforeEach
    void setup() {
        exoplanetCommentRepository = createMockRepo();
        exoplanetCommentService = new ExoplanetCommentService(exoplanetCommentRepository);
    }

    @Test
    void testSaveComment(){
        ExoplanetComments comment = new ExoplanetComments();
        comment.setComment("test");
        comment.setExoplanetCommentId(1);
        comment.setExoplanetCommentId(1);

        exoplanetCommentService.createComment(comment);

        assertEquals(savedComment.getComment(), "test");
        assertEquals(savedComment.getExoplanetCommentId(), 1);
    }

    public ExoplanetCommentRepository createMockRepo() {
        ExoplanetCommentRepository mockRepo = mock(ExoplanetCommentRepository.class);
        try {
            doAnswer(
                    (Answer<Void>) invocation -> {
                        savedComment = (ExoplanetComments) invocation.getArguments()[0];
                        return null;
                    })
                    .when(mockRepo)
                    .save(any(ExoplanetComments.class));
        } catch (Exception e) {
        }
        return mockRepo;
    }
}
