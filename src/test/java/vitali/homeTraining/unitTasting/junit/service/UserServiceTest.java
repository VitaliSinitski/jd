package vitali.homeTraining.unitTasting.junit.service;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;

import vitali.homeTrainig.unitTasting.junit.dto.User;
import vitali.homeTrainig.unitTasting.junit.service.UserService;

import java.util.List;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {
    private UserService userService;

    @BeforeAll
    void init() {
        System.out.println("Before all: " + this);
    }

    @BeforeEach
    void prepare() {
        System.out.println("Before each: " + this);
        userService = new UserService();
    }

    @Test
    void usersEmptyIfNotUsersAdded() {
        System.out.println("Test 1: " + this);
        List<User> users = userService.getAll();
        assertTrue(users.isEmpty());
    }

    @Test
    void usersSizeIfUserAdded() {
        System.out.println("Test 2: " + this);
//        userService.add(new User());
//        userService.add(new User());

        List<User> users = userService.getAll();

        assertThat(users).hasSize(2);
//        assertEquals(2, users.size());
    }

    @Test
    void usersConvertedToMapById() {
//        userService.add(Ivan)
    }

    @AfterEach
    void deleteDataFromDatabase() {
        System.out.println("After each: " + this);
    }

    @AfterAll
    void closeConnectionPool() {
        System.out.println("After all: " + this);
    }


}
