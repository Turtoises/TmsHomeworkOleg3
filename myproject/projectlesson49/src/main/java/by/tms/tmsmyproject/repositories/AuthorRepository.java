package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    boolean existsByNameAndSurname(String name, String surname);

    Optional<Author> getByNameAndSurname(String name, String surname);

    @Query("SELECT a.id FROM Author a WHERE a.name= :name AND a.surname= :surname")
    Long getIdByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

}
