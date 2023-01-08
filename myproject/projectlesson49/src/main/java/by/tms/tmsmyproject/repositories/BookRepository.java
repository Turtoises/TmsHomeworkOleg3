package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.Author;
import by.tms.tmsmyproject.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByName(String name);

    boolean existsBookByNameAndYearAndAuthor(String name, Integer year, Author author);

    Page<Book> findBookByGenreBook(String genre, Pageable pageable);

}