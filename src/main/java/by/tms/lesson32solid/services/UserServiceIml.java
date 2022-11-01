package by.tms.lesson32solid.services;

import by.tms.lesson32solid.entities.User;
import by.tms.lesson32solid.repositories.UserRepository;
import by.tms.lesson32solid.repositories.UserRepositoryIml;
import by.tms.lesson32solid.utils.FindNullUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@Slf4j
public class UserServiceIml implements UserService {

    private UserRepository userRepository;

    public UserServiceIml() {
        this.userRepository = new UserRepositoryIml();
    }

    @Override
    public boolean changePassword(String login, String oldPassword, String newPassword) {

        if (FindNullUtils.isAnyNull(login, oldPassword, newPassword)) {
            return false;
        }

        User user = userRepository.findByLogin(login);
        boolean isСhangePassword = false;

        if (user.getPassword().equals(oldPassword) && !newPassword.isEmpty()) {
            user.setPassword(newPassword);
            userRepository.add(user);
            isСhangePassword = true;
            log.info("Change password successful");
        } else {
            log.info("Change password NOT successful");
        }
        return isСhangePassword;
    }

    @Override
    public boolean delete(String login, String password) {

        if (FindNullUtils.isAnyNull(login, password)) {
            return false;
        }

        if (!userRepository.isUser(login)) {
            log.info("User not find");
            return false;
        }
        if (Objects.equals(userRepository.findByLogin(login).getPassword(), password)) {
            userRepository.delete(login);
            log.info("Delete user successful");
            return true;
        }
        log.info("Delete user NOT successful");
        return false;
    }

    @Override
    public boolean create(String login, String password) {

        if (FindNullUtils.isAnyNull(login, password)) {
            return false;
        }

        if (login.isEmpty() || password.isEmpty()) {
            log.info("Date is empty");
            return false;
        }

        if (userRepository.isUser(login)) {
            log.info("The user already exists");
            return false;
        }

        userRepository.add(new User(login, password));
        log.info("Creat user successful");
        return true;
    }

    @Override
    public boolean isEmpty() {
        return userRepository.isEpty();
    }

    public boolean isUser(String login) {
        if (FindNullUtils.isAnyNull(login)) {
            return false;
        }
        return userRepository.isUser(login);
    }
}
