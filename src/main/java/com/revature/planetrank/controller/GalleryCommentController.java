package com.revature.planetrank.controller;

import com.revature.planetrank.model.GalleryComments;
import com.revature.planetrank.service.GalleryCommentService;
import com.revature.planetrank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*", exposedHeaders = "*", allowedHeaders = "*")
public class GalleryCommentController {

    @Autowired
    private GalleryCommentService exoplanetCommentService;
    @Autowired
    private UserService userService;
    @Autowired
    private GalleryCommentService galleryCommentService;

    @PostMapping("/images/{nasa_id}/{user_id}")
    public GalleryComments createComment(@RequestBody GalleryComments comment, @PathVariable("user_id") Integer userId,
                                   @PathVariable("nasa_id") String nasaId) {
        comment.setNasaId(nasaId);
        comment.setAuthorId(userId);
        String authorUserName = galleryCommentService.getAuthorUserNameByAuthorId(userId);
        comment.setAuthorName(authorUserName);
        return galleryCommentService.createComment(comment);
    }

    @GetMapping("/images/{nasa_id}/comments")
    public List<GalleryComments> getAllCommentsForImage(@PathVariable("nasa_id") String nasaId) {
        List<GalleryComments> imageComments = galleryCommentService.getAllGalleryCommentsByNasaId(nasaId);
        return imageComments;
    }


}
