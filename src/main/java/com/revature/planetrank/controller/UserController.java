package com.revature.planetrank.controller;

import com.revature.planetrank.model.User;
import com.revature.planetrank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*", exposedHeaders = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return userList;
    }
    @PostMapping("/user")
    public User createNewUser(@RequestBody User user){
        // Encrypt password
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        User newUser = userService.createUser(user);
        return newUser;
    }
}
