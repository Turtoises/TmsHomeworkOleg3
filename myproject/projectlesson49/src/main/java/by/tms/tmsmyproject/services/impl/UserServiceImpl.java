package by.tms.tmsmyproject.services.impl;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.exception.EntityNotCreateException;
import by.tms.tmsmyproject.exception.EntityNotFoundException;
import by.tms.tmsmyproject.repositories.UserRepository;
import by.tms.tmsmyproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Transactional
    @Override
    public User deleteById(Long id) {
        User user = getById(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with id=%s not found", id)));
    }

    @Transactional
    @Override
    public User create(User user) {
        String errorMessage = getErrorCreateMessage(user);
        if (!errorMessage.isEmpty()) {
            throw new EntityNotCreateException(errorMessage);
        }
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        User userOld = getById(user.getId());
        user.setLogin(userOld.getLogin());
        user.setEmail(userOld.getEmail());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        List<User> userList = userRepository.findAll();
        if (CollectionUtils.isEmpty(userList)) {
            throw new EntityNotFoundException("There are no users to represent");
        }
        return userList;
    }

    @Override
    public Page<User> getAllPaginated(Pageable pageable) {
        Page<User> page = null;
        try {
            page = userRepository.findAll(pageable);
        } catch (Exception e) {
            throw new EntityNotFoundException("Fieldname incorrect");
        }
        return page;
    }

    @Override
    public boolean isUserLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public boolean isUserEmail(String email) {
        return userRepository.existsByEmail(email);
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
