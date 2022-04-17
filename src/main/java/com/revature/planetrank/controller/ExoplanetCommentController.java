package com.revature.planetrank.controller;

import com.revature.planetrank.model.ExoplanetComments;
import com.revature.planetrank.service.ExoplanetCommentService;
import com.revature.planetrank.service.ExoplanetService;
import com.revature.planetrank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", exposedHeaders = "*", allowedHeaders = "*")
public class ExoplanetCommentController {

    @Autowired
    private ExoplanetCommentService exoplanetCommentService;
    @Autowired
    private UserService userService;
    @Autowired
    private ExoplanetService exoplanetService;

    @PostMapping("/{user_id}/{card_id}")
    public ExoplanetComments createComment(@RequestBody ExoplanetComments comment, @PathVariable("user_id") Integer userId, @PathVariable("card_id") Integer cardId) {
        comment.setExoplanetId(cardId);
        comment.setAuthorId(userId);
        return exoplanetCommentService.createComment(comment);
    }
}
