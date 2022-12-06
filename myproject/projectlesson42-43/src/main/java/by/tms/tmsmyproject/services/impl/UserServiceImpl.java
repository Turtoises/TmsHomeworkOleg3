package by.tms.tmsmyproject.services.impl;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.repositories.UserRepository;
import by.tms.tmsmyproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository repository;

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public boolean delete(User userDto) {
        return repository.deleteByLogin(userDto.getLogin());
    }

    @Override
    public User getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public User getByLogin(String login) {
        return repository.getByLogin(login);
    }

    @Override
    public boolean isUserLogin(String login) {
        return repository.isUserLogin(login);
    }

    @Override
    public boolean isUserEmail(String email) {
        return repository.isUserEmail(email);
    }

    @Override
    public boolean create(User user) {
        return repository.create(user);
    }

    @Override
    public boolean update(User user) {
        return repository.update(user);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
