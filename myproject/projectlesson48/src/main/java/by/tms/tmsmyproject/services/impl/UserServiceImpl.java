package by.tms.tmsmyproject.services.impl;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.exception.UserNotCreateException;
import by.tms.tmsmyproject.exception.UserNotFoundException;
import by.tms.tmsmyproject.repositories.UserRepository;
import by.tms.tmsmyproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository repository;

    @Transactional
    @Override
    public User deleteById(Long id) {
        if (!repository.isUserId(id)) {
            throw new UserNotFoundException(String.format("User with id=%d not found", id));
        }
        User user = repository.getById(id);
        repository.deleteById(id);
        return user;
    }

    @Override
    public User getById(Long id) {
        if (!repository.isUserId(id)) {
            throw new UserNotFoundException(String.format("User with id=%s not found", id));
        }
        return repository.getById(id);
    }
    @Transactional
    @Override
    public User create(User user) {
        String errorMessage = getErrorCreateMessage(user);
        if (!errorMessage.isEmpty()) {
            throw new UserNotCreateException(errorMessage);
        }
        return repository.create(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        Long id = user.getId();
        if (!repository.isUserId(id)) {
            throw new UserNotFoundException(String.format("User with id=%s not found", id));
        }
        User userOld = repository.getById(id);
        user.setLogin(userOld.getLogin());
        user.setEmail(userOld.getEmail());
        repository.update(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = repository.getAll();
        if (CollectionUtils.isEmpty(userList)) {
            throw new UserNotFoundException("There are no users to represent");
        }
        return userList;
    }

    @Override
    public boolean isUserLogin(String login) {
        return repository.isUserLogin(login);
    }

    @Override
    public boolean isUserEmail(String email) {
        return repository.isUserEmail(email);
    }

    private String getErrorCreateMessage(User user) {
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
