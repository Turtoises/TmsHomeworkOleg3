package by.tms.lesson32solid.services;

import by.tms.lesson32solid.entities.User;
import by.tms.lesson32solid.repositories.UserRepository;
import by.tms.lesson32solid.utils.FindNullUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@Slf4j
public class UserServiceIml implements UserService {

    private static Logger logger = LoggerFactory.getLogger("UserServiceIml");

    private UserRepository userRepository;

    public UserServiceIml(UserRepository userRepository) {
        this.userRepository = userRepository;
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
            logger.info("Change password successful");
        } else {
            logger.info("Change password NOT successful");
        }
        return isСhangePassword;
    }

    @Override
    public boolean delete(String login, String password) {

        if (FindNullUtils.isAnyNull(login, password)) {
            return false;
        }

        if (!userRepository.isUser(login)) {
            logger.info("User not find");
            return false;
        }
        if (Objects.equals(userRepository.findByLogin(login).getPassword(), password)) {
            userRepository.delete(login);
            logger.info("Delete user successful");
            return true;
        }
        logger.info("Delete user NOT successful");
        return false;
    }

    @Override
    public boolean create(String login, String password) {

        if (FindNullUtils.isAnyNull(login, password)) {
            return false;
        }

        if (login.isEmpty() || password.isEmpty()) {
            logger.info("Date is empty");
            return false;
        }

        if (userRepository.isUser(login)) {
            logger.info("The user already exists");
            return false;
        }

        userRepository.add(new User(login, password));
        logger.info("Creat user successful");
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
