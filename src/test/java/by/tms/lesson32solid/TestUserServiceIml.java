package by.tms.lesson32solid;

import by.tms.lesson32solid.services.UserService;
import by.tms.lesson32solid.services.UserServiceIml;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserServiceIml {

    UserService userService = new UserServiceIml();

    @ParameterizedTest
    @CsvSource(value = {
            "german, 12345, 7777, true",
            "ivan, 11111, 9999,false",
            "ivan, null,777,false"
    })
    public void testChangePassword(String login, String oldPassword, String newPassword, boolean result) {
        if (oldPassword.equals("null")) {
            oldPassword = null;
        }
        boolean isCange = userService.changePassword(login, oldPassword, newPassword);
        assertEquals(isCange, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "german, 12345, true",
            "ivan, 11111, false"
    })
    public void testDelete(String login, String password, boolean result) {
        boolean isDelete = userService.delete(login, password);
        assertEquals(isDelete, result);
    }

}
