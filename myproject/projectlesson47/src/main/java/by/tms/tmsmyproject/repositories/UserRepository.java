package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean findByLoginTrue(String login);

    boolean findByEmailTrue(String email);

    User findByLogin(String login);
}
