package com.revature.planetrank.service;


import com.revature.planetrank.dao.UserRepository;
import com.revature.planetrank.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;
import java.sql.Driver;


@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepo;

    public static Logger log = LoggerFactory.getLogger(Driver.class);

    public User login(String username, String password) throws FailedLoginException {

        // trim() will trim all leading and trailing whitespace

//        User user = userRepo.findByUsernameAndPassword(username.trim(), BCrypt.hashpw(password.trim(),BCrypt.gensalt()));
        User user1 = userRepo.findByUsername(username.trim());
        System.out.println(user1);
        if(!BCrypt.checkpw(password,user1.getPassword())){
            log.info("\nInvalid user/pass with credentials" +
                    "\nusername: " + username +
                    "\npassword: " + password);
            throw new FailedLoginException("Invalid username and/or password");
        }
        // No User in the database matched a particular username and password
//        if (user == null) {
//            log.info("\nInvalid user/pass with credentials" +
//                    "\nusername: " + username +
//                    "\npassword: " + password);
//            throw new FailedLoginException("Invalid username and/or password");
//        }

        return user1;
    }
}
