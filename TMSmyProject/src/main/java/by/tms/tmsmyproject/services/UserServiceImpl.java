package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.ResponseMessage;
import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.repositories.UserRepositoryIml;
import by.tms.tmsmyproject.utils.ConstantsRegex;
import by.tms.tmsmyproject.utils.FindNullAndEmptyUtil;
import by.tms.tmsmyproject.utils.UserMapperUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserServiceImpl extends AbstractUserService {

    public UserServiceImpl() {
        this.repository = new UserRepositoryIml();
    }

    @Override
    public ResponseMessage deleteById(Long id) {
        User userDelete = null;
        try {
            userDelete = repository.getById(id);
        } catch (SQLException e) {
            return new ResponseMessage(false, "SQL Exception");
        }

        if (userDelete.getId() == null) {
            String message = String.format("User with ID=%d not find", id);
            log.info(message);
            return new ResponseMessage(false, message);
        }
        try {
            repository.deleteById(id);
        } catch (SQLException e) {
            new ResponseMessage(false, "SQL Exception");
        }
        return new ResponseMessage(true, UserMapperUtil.getUserLoginIdDto(userDelete));
    }

    @Override
    public ResponseMessage delete(User userDto) {
        try {
            String message = getStringErrorInUserDataDelete(userDto);
            if (!message.isEmpty()) {
                return new ResponseMessage(false, message);
            }
            repository.deleteByLogin(userDto.getLogin());
        } catch (SQLException e) {
            return new ResponseMessage(false, "SQL Exception");
        }
        return new ResponseMessage(true, userDto);
    }

    @Override
    public ResponseMessage getById(Long id) {
        if (id == null) {
            String message = "ID is empty";
            return new ResponseMessage(false, message);
        }

        User user = new User();

        try {
            user = repository.getById(id);
        } catch (SQLException e) {
            return new ResponseMessage(false, "SQL Exception");
        }
        if (user.getId() == null) {
            String message = String.format("User with ID=%d not find", id);
            return new ResponseMessage(false, message);
        }
        return new ResponseMessage(true, user);
    }

    public ResponseMessage getByLogin(String login) {

        if (login == null || login.isEmpty()) {
            String message = "login is empty";
            return new ResponseMessage(false, message);
        }
        User user = new User();

        try {
            user = repository.getByLogin(login);
        } catch (SQLException e) {
            return new ResponseMessage(false, "SQL Exception");
        }
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
        try {
            List<String> listErrorInUserData = getListErrorInUserDataCreate(user);
            if (!listErrorInUserData.isEmpty()) {
                return new ResponseMessage(false, listErrorInUserData);
            }
            repository.create(user);
        } catch (SQLException e) {
            return new ResponseMessage(false, "SQL Exception");
        }
        return new ResponseMessage(true, UserMapperUtil.getUseCreateDto(user));
    }

    @Override
    public ResponseMessage update(User entity) {
        return new ResponseMessage();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    private List<String> getListErrorInUserDataCreate(User user) throws SQLException {
        List<String> error = new ArrayList<>();

        if (FindNullAndEmptyUtil.isAnyNullOrEmpty(user.getArrayFields())) {
            String message = "There are unfilled fields";
            error.add(message);
            return error;
        }

        String login = user.getLogin();
        String password = user.getPassword();
        String email = user.getEmail();
        String name = user.getName();
        String surname = user.getSurname();

        if (!name.matches(ConstantsRegex.NAME_USER)) {
            error.add("name incorrect");
        }
        if (!surname.matches(ConstantsRegex.NAME_USER)) {
            error.add("surname incorrect");
        }
        if (!login.matches(ConstantsRegex.LOGIN)) {
            error.add("login incorrect");
        }
        if (!password.matches(ConstantsRegex.PASSWORD)) {
            error.add("password incorrect");
        }
        if (!email.matches(ConstantsRegex.EMAIL)) {
            error.add("email incorrect");
        }
        if (!error.isEmpty()) {
            return error;
        }
        if (repository.isUserLogin(user.getLogin())) {
            error.add("This login already exists");
        }
        if (repository.isUserEmail(user.getEmail())) {
            error.add("This email is already taken");
        }
        return error;
    }

    private String getStringErrorInUserDataDelete(User user) throws SQLException {

        String login = user.getLogin();
        String password = user.getPassword();
        String message = "";

        if (FindNullAndEmptyUtil.isAnyNullOrEmpty(login, password)) {
            message = "Login or password is incorrect";
            return message;
        }
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
