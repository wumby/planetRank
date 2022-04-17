package com.revature.planetrank.controller;


import com.revature.planetrank.dao.ImageRepository;
import com.revature.planetrank.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/nasa_images")
@CrossOrigin(originPatterns = "*", exposedHeaders = "*", allowedHeaders = "*")
public class GalleryController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/images")
    public ResponseEntity<List<Image>> getAllImages() {
        try {
            List<Image> images = new ArrayList<Image>();


            images.addAll(imageRepository.findAll());

            if (images.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(images, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/images/{nasa_id}")
    public ResponseEntity<List<Image>> getImageByNasaId(@PathVariable("nasa_id") String nasaId){
        try{
            List<Image> image = new ArrayList<Image>();
            image.addAll(imageRepository.findByNasaId(nasaId));

            if (image.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(image, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
