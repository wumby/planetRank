package com.revature.planetrank.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.planetrank.model.LoginDTO;
import com.revature.planetrank.model.User;
import com.revature.planetrank.service.AuthenticationService;
import com.revature.planetrank.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;
import java.sql.Driver;

@RestController
@CrossOrigin(originPatterns = "*", exposedHeaders = "*", allowedHeaders = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtService jwtService;

    public static Logger log = LoggerFactory.getLogger(Driver.class);


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) throws FailedLoginException {

        try{
            User user = authenticationService.login(dto.getUsername(), dto.getPassword());

            String jwt = jwtService.createJwt(user);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("token", jwt);

            log.info("\nLogin endpoint has been successfully invoked." +
                    "\nDTO username: " + dto.getUsername() + "\n");

            return ResponseEntity.ok().headers(responseHeaders).body(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body(e.getMessage());
        }



    }


    @GetMapping("/test")
    public String test(){
        String test = "test";
        return test;
    }
}
