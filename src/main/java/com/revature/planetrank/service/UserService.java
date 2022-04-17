package com.revature.planetrank.service;

import com.revature.planetrank.dao.UserRepository;
import com.revature.planetrank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public final UserRepository userRepository;

    public User createUser(User user){
        User newUser = userRepository.save(user);
        return newUser;
    };
    public List<User> getAllUsers(){return userRepository.findAll();}
    public User getUserById(int id){
        return userRepository.getById(id);
    }
}
