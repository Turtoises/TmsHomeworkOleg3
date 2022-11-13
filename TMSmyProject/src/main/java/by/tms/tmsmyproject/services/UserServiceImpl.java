package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.enums.RoleUser;
import by.tms.tmsmyproject.repositories.UserRepository;
import by.tms.tmsmyproject.repositories.UserRepositoryIml;
import by.tms.tmsmyproject.utils.Constants;
import by.tms.tmsmyproject.utils.ConstantsRegex;
import by.tms.tmsmyproject.utils.FindNullAndEmptyUtil;
import by.tms.tmsmyproject.utils.UserMapperUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserServiceImpl extends AbstractService<User, UserRepository> {

    public UserServiceImpl(HttpServletRequest request) {
        this.request = request;
        this.repository = new UserRepositoryIml();
    }

    @Override
    public boolean deleteById(Long id) {
        HttpSession session = request.getSession();
        if (!session.getAttribute(Constants.SESSION_ATTRIBUTE_ROLE).equals(RoleUser.ADMIN.toString())) {
            String message = "The operation is only available with administrator rights. Deleting a user by ID is not performed";
            request.setAttribute(Constants.ATTRIBUTE_DELETE_USER_BY_ID, message);
            log.info(message);
            return false;
        }
        User userDelete = repository.getById(id);
        if (userDelete.getId() == null) {
            String message = String.format("User with ID=%d not find", id);
            request.setAttribute(Constants.ATTRIBUTE_DELETE_USER_BY_ID, message);
            log.info(message);
            return false;
        }
        request.setAttribute(Constants.ATTRIBUTE_DELETE_USER_BY_ID, UserMapperUtil.getUserLoginIdDto(userDelete));
        return repository.deleteById(id);
    }

    @Override
    public boolean delete(User userDto) {
        String login = userDto.getLogin();
        String password = userDto.getPassword();

        if (FindNullAndEmptyUtil.isAnyNullOrEmpty(login, password)) {
            String message = "Login or password is incorrect";
            request.setAttribute(Constants.ATTRIBUTE_DELETE_USER_BY_LOGIN, message);
            log.info(message);
            return false;
        }
        User userDelete = repository.getByLogin(login);
        String passwordInBase = userDelete.getPassword();
        if (passwordInBase == null) {
            String message = String.format("User with login %s not find", login);
            request.setAttribute(Constants.ATTRIBUTE_DELETE_USER_BY_LOGIN, message);
            log.info(message);
            return false;
        }
        if (!password.equals(passwordInBase)) {
            String message = String.format("The user with the login %s has a different password", login);
            request.setAttribute(Constants.ATTRIBUTE_DELETE_USER_BY_LOGIN, message);
            log.info(message);
            return false;
        }
        return repository.deleteByLogin(login);
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public boolean create(User user) {
        List<String> messageList = new ArrayList<>();

        try {
            messageList = errorList(user);
        } catch (SQLException e) {
            messageList.add("SQLException");
            request.setAttribute(Constants.ATTRIBUTE_CREATE_USER, messageList);
            log.info("SQLException create");
            return false;
        }
        if (!messageList.isEmpty()) {
            request.setAttribute(Constants.ATTRIBUTE_CREATE_USER, messageList);
            return false;
        }

        return repository.create(user);
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    private List<String> errorList(User user) throws SQLException {
        List<String> error = new ArrayList<>();

        if (FindNullAndEmptyUtil.isAnyNullOrEmpty(user.getArrayFields())) {
            String message = "There are unfilled fields";
            error.add(message);
            log.info(message);
            return error;
        }

        String login = user.getLogin();
        String password = user.getPassword();
        String email = user.getEmail();
        String name = user.getName();
        String surname = user.getSurname();

        if (!name.matches(ConstantsRegex.NAME)) {
            error.add("name incorrect");
        }
        if (!surname.matches(ConstantsRegex.NAME)) {
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

}
