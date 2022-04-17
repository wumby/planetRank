package com.revature.planetrank.service;

import com.revature.planetrank.dao.GalleryCommentRepository;
import com.revature.planetrank.dao.UserRepository;
import com.revature.planetrank.model.GalleryComments;
import com.revature.planetrank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryCommentService {

    @Autowired
    private GalleryCommentRepository galleryCommentRepository;

    @Autowired
    private UserRepository userRepo;

    public GalleryComments createComment(GalleryComments comment){

        return galleryCommentRepository.save(comment);
    }

    public List<GalleryComments> getAllGalleryCommentsByNasaId(String nasaId) {
        return galleryCommentRepository.findByNasaIdOrderByUploadDateDesc(nasaId);
    }

    public String getAuthorUserNameByAuthorId(int authorId){
        User author = userRepo.findByUserId(authorId);
        return author.getUsername();
    }

}

