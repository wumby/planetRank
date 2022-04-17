package com.revature.planetrank.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.planetrank.model.User;
import com.revature.planetrank.model.UserJwtDto;

import java.security.Key;
import java.sql.Driver;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class JwtService {

    private static JwtService instance;
    public static Logger log = LoggerFactory.getLogger(Driver.class);
    private Key key;

    // created an instance of jwt service and made the constructor private
    // singleton class
    public JwtService() {
//        byte[] secret = "my_secret_passwordafdsalkj;lkvjasd;lkfoijeowiru324u02938098134lkhj;ldjfa;sldkjfDSFSLDKJFLSKJF".getBytes();
//        key = Keys.hmacShaKeyFor(secret);
        key = Keys.secretKeyFor(SignatureAlgorithm.HS384);
    }

    public static JwtService getInstance() {
        if (JwtService.instance == null) {
            JwtService.instance = new JwtService();
        }
        log.info("\nNew JWTService instance called\n");
        return JwtService.instance;
    }

    public String createJwt(User user) throws JsonProcessingException {
        UserJwtDto dto = new UserJwtDto(user.getUserId(), user.getUsername(), user.getRole().getRole());

        String jwt = Jwts.builder()
                .claim("user_dto", new ObjectMapper().writeValueAsString(dto))
                .signWith(key)
                .compact();
        log.info("\nA token has been built, returning said token. [JWT Service Layer]\n");
        return jwt;
    }

    public UserJwtDto parseJwt(String jwt) throws JsonProcessingException {
        Jws<Claims> token = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);

        String dtoString = (String) token.getBody().get("user_dto");

        log.info("\nParsing Successful! Returning token\n");
        return (new ObjectMapper()).readValue(dtoString, UserJwtDto.class);

        // potentially catch an invalid token ?
        // throw new Unauthorized Response
    }
}
