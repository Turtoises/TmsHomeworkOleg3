package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends CrudService<User> {

    boolean isUserLogin(String login);

    boolean isUserEmail(String email);

}
