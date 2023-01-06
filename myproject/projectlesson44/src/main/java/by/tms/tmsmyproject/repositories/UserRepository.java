package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.User;

public interface UserRepository extends CrudRepository<User> {

    boolean deleteByLogin(String login);

    User getByLogin(String login);

    boolean isUserId(Long id);

    boolean isUserLogin(String login);

    boolean isUserEmail(String email);

}
