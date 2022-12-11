package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.User;

public interface UserService extends CrudService<User> {

    User getByLogin(String login);

    boolean isUserLogin(String login);

    boolean isUserEmail(String email);

}
