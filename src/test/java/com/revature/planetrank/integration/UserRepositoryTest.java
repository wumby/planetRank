package com.revature.planetrank.integration;


import com.revature.planetrank.dao.UserRepository;
import com.revature.planetrank.model.User;
import com.revature.planetrank.model.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Profile("test")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepo;



    @Test
    @Transactional
    public void test_get_user_by_username_valid(){
        //Act
        User actual = userRepo.findByUsername("username");

        // Assert
        UserRole expectedUserRole = new UserRole();
        expectedUserRole.setId(1);
        expectedUserRole.setRole("member");

        User expected = new User();
        expected.setUserId(1);
        expected.setUsername("username");
        expected.setPassword("password");
        expected.setRole(expectedUserRole);

        Assertions.assertEquals(expected, actual);





    }

}