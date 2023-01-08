package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService extends CrudService<Book>{

    Book findByName(String name);

    boolean isBook(Book book);

    Page<Book> findBookByGenreOrAll(String genre, Pageable pageable);

}
