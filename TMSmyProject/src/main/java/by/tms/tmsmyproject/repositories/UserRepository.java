package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.User;

import java.sql.SQLException;

public interface UserRepository extends Repository<User> {

    boolean deleteByLogin(String login) throws SQLException;

    User getByLogin(String login) throws SQLException;

    boolean isUserLogin(String login) throws SQLException;

    boolean isUserEmail(String email) throws SQLException;

}
