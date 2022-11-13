package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.User;

import java.sql.SQLException;

public interface UserRepository extends AbstractRepository<User> {

    boolean deleteByLogin(String login);

    User getByLogin(String login);

    boolean isUserLogin(String login) throws SQLException;

    boolean isUserEmail(String email) throws SQLException;

}
