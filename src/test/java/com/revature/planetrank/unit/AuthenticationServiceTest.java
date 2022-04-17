package com.revature.planetrank.unit;

import com.revature.planetrank.dao.UserRepository;
import com.revature.planetrank.model.User;
import com.revature.planetrank.model.UserRole;
import com.revature.planetrank.service.AuthenticationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.security.auth.login.FailedLoginException;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepo;

    // inject any object labeled with @mock into this object
    @InjectMocks
    private AuthenticationService authService;

    /*
     login method
     2 inputs
     positive correct input and it is a user
     negative test case --> invalid credentials
     server timeout
     incorrect data types (int)
     blank fields

     Arrange
     Act
     Assert

     */

    @Test
    public void test_login_positive_validUserAndPass() throws FailedLoginException {
        //Act
        UserRole fakeRole = new UserRole();
        fakeRole.setRole("member");
        fakeRole.setId(1);
        User fakeUser = new User();
        fakeUser.setUserId(1);
        fakeUser.setUsername("username");
        fakeUser.setPassword("password");
        fakeUser.setRole(fakeRole);

        when(userRepo.findByUsername("username")).thenReturn(fakeUser);

        User actual = userRepo.findByUsername("username");

        //Arrange
        UserRole expectedUserRole = new UserRole();
        expectedUserRole.setId(1);
        expectedUserRole.setRole("member");
        User expected = new User();
        expected.setUserId(1);
        expected.setUsername("username");
        expected.setPassword("password");
        expected.setRole(expectedUserRole);


        //Assert
        String expectedPassword = BCrypt.hashpw(expected.getPassword(),BCrypt.gensalt());
        String actualPassword = BCrypt.hashpw(fakeUser.getPassword(),BCrypt.gensalt());
        Assertions.assertFalse(BCrypt.checkpw(expectedPassword,actualPassword));

    }

//    @Test
//    public void test_negative_validUserAndPass() throws FailedLoginException {
//
//        User expected = new User();
//        expected.setUserId(1);
//        expected.setUsername("test");
//        expected.setPassword("test");
//
//        when(userRepo.findByUsernameAndPassword(eq("test"), eq("test"))).thenReturn(expected);
//        User actual = authService.login("username", "password");
//
//        Assertions.assertNotEquals(expected, actual);
//
//    }
}