package vitali.homeTraining.unitTasting.junit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import vitali.homeTrainig.unitTasting.junit.dto.User;
import vitali.homeTrainig.unitTasting.junit.service.UserService;

import java.util.List;


class UserServiceTest {
    @Test
    void usersEmptyIfNotUsersAdded() {
        var userService = new UserService();
        List<User> users = userService.getAll();
        Assertions.assertTrue(users.isEmpty());
    }
}
