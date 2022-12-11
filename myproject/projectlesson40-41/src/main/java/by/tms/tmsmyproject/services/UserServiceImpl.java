package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.ResponseMessage;
import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.repositories.UserRepository;
import by.tms.tmsmyproject.utils.UserMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository repository;

    @Override
    public ResponseMessage deleteById(Long id) {
        if (id == null) {
            String message = "ID is empty";
            return new ResponseMessage(false, message);
        }
        User userDelete = repository.getById(id);
        if (!repository.deleteById(id)) {
            String message = String.format("User with ID=%d not find", id);
            return new ResponseMessage(false, message);
        }

        return new ResponseMessage(true, UserMapperUtil.getUserLoginIdDto(userDelete));
    }

    @Override
    public ResponseMessage delete(User userDto) {

        String message = getStringErrorInUserDataDelete(userDto);
        if (!message.isEmpty()) {
            return new ResponseMessage(false, message);
        }
        repository.deleteByLogin(userDto.getLogin());

        return new ResponseMessage(true, userDto);
    }

    @Override
    public ResponseMessage getById(Long id) {
        if (id == null) {
            String message = "ID is empty";
            return new ResponseMessage(false, message);
        }

        User user = repository.getById(id);

        if (user.getId() == null) {
            String message = String.format("User with ID=%d not find", id);
            return new ResponseMessage(false, message);
        }
        return new ResponseMessage(true, user);
    }

    @Override
    public ResponseMessage getByLogin(String login) {
        User user = repository.getByLogin(login);

        if (user.getId() == null) {
            String message = String.format("User with login=%d not find", login);
            return new ResponseMessage(false, message);
        }
        return new ResponseMessage(true, user);
    }

    /*public User getRoleOrNull(User userDto){
        String login = userDto.getLogin();
        String password = userDto.getPassword();
    }*/

    @Override
    public ResponseMessage create(User user) {
        List<String> listErrorInUserData = getListErrorInUserDataCreate(user);

        if (!listErrorInUserData.isEmpty()) {
            return new ResponseMessage(false, listErrorInUserData);
        }
        repository.create(user);

        return new ResponseMessage(true, UserMapperUtil.getUseCreateDto(user));
    }

    @Override
    public ResponseMessage update(User entity) {
        return new ResponseMessage();
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    private List<String> getListErrorInUserDataCreate(User user) {
        List<String> error = new ArrayList<>();

        if (repository.isUserLogin(user.getLogin())) {
            error.add("This login already exists");
        }
        if (repository.isUserEmail(user.getEmail())) {
            error.add("This email is already taken");
        }
        return error;
    }

    private String getStringErrorInUserDataDelete(User user) {

        String login = user.getLogin();
        String password = user.getPassword();
        String message = "";

        User userDelete = repository.getByLogin(login);

        String passwordInBase = userDelete.getPassword();

        if (passwordInBase == null) {
            message = String.format("User with login %s not find", login);
            return message;
        }
        if (!password.equals(passwordInBase)) {
            message = String.format("The user with the login %s has a different password", login);
            return message;
        }
        return message;
    }
}
