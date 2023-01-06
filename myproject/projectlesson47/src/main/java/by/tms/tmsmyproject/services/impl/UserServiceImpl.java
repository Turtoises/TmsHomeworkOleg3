package by.tms.tmsmyproject.services.impl;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.exception.UserNotCreateException;
import by.tms.tmsmyproject.exception.UserNotFoundException;
import by.tms.tmsmyproject.repositories.UserRepository;
import by.tms.tmsmyproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public User deleteById(Long id) {
        User user = getById(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id=%s not found", id)));
    }

    @Override
    public User create(User user) {

        String errorMessage = getErrorCreateMessage(user);
        if (!errorMessage.isEmpty()) {
            throw new UserNotCreateException(errorMessage);
        }
        userRepository.save(user);
        return userRepository.findByLogin(user.getLogin());
    }

    @Override
    public User update(User user) {
        User userOld = getById(user.getId());
        user.setLogin(userOld.getLogin());
        user.setEmail(userOld.getEmail());
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = userRepository.findAll();
        if (CollectionUtils.isEmpty(userList)) {
            throw new UserNotFoundException("There are no users to represent");
        }
        return userList;
    }

    @Override
    public boolean isUserLogin(String login) {
        return userRepository.findByLoginTrue(login);
    }

    @Override
    public boolean isUserEmail(String email) {
        return userRepository.findByEmailTrue(email);
    }

    public String getErrorCreateMessage(User user) {
        String error = "";
        String login = user.getLogin();
        String email = user.getEmail();

        if (isUserLogin(login)) {
            error += String.format("The user with the login=%s already exists. ", login);
        }
        if (isUserEmail(email)) {
            error += String.format("The user with the email=%s already exists", email);
        }
        return error;
    }
}
