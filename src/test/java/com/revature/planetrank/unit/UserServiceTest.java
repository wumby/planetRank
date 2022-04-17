package com.revature.planetrank.unit;

import com.revature.planetrank.dao.UserRepository;
import com.revature.planetrank.model.User;
import com.revature.planetrank.model.UserRole;
import com.revature.planetrank.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;

    private static User savedUser;

    @BeforeEach
    void setup() {
        userRepository = createMockRepo();
        userService = new UserService(userRepository);
    }

    @Test
    void testSaveUser(){
        UserRole newRole = new UserRole();
        newRole.setRole("member");
        newRole.setId(1);
        User user = new User();
        user.setUserId(1);
        user.setUsername("test");
        user.setPassword("test");
        user.setRole(newRole);

        userService.createUser(user);

        assertEquals(savedUser.getUsername(), "test");
        assertEquals(savedUser.getPassword(), "test");
    }

    public UserRepository createMockRepo() {
        UserRepository mockRepo = mock(UserRepository.class);
        try {
            doAnswer(
                    (Answer<Void>) invocation -> {
                        savedUser = (User) invocation.getArguments()[0];
                        return null;
                    })
                    .when(mockRepo)
                    .save(any(User.class));
        } catch (Exception e) {
        }
        return mockRepo;
    }
}
