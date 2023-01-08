package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);


}
