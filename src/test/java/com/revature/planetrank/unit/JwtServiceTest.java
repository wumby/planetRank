package com.revature.planetrank.unit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.planetrank.model.User;
import com.revature.planetrank.model.UserRole;
import com.revature.planetrank.service.JwtService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JwtServiceTest {
    private JwtService jwtService = new JwtService();

    @Test
    public void testSingleton(){
        JwtService instance = jwtService.getInstance();

        JwtService expected = instance;

        JwtService actual =instance;
        Assertions.assertEquals(expected,actual);

    }

    @Test
    public void testCreateValidJwt() throws JsonProcessingException {
        String jwt = jwtService.createJwt(new User(1, "username", "password",new UserRole(1,"member")));

        Assertions.assertEquals(192, jwt.length());
    }




}

