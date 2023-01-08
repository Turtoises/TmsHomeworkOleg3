package by.tms.tmsmyproject.services.impl;

import by.tms.tmsmyproject.entities.Author;
import by.tms.tmsmyproject.entities.Book;
import by.tms.tmsmyproject.exception.EntityNotCreateException;
import by.tms.tmsmyproject.exception.EntityNotFoundException;
import by.tms.tmsmyproject.repositories.BookRepository;
import by.tms.tmsmyproject.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    AuthorServiceImpl authorService;

    @Transactional
    @Override
    public Book deleteById(Long id) {
        Book book = getById(id);
        bookRepository.deleteById(id);
        return book;
    }

    @Transactional
    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Book with id=%s not found", id)));
    }

    @Transactional
    @Override
    public Book create(Book book) {
        Author author = authorService.getById(book.getAuthor().getId());
        List<Book> books = author.getBooks();
        if (books.contains(book)) {
            throw new EntityNotCreateException(String.format(
                    "The book name=%s by author with name=%s and surname=%s already exists.", book.getName(), author.getName(), author.getSurname()));
        }
        books.add(book);
        author.setBooks(books);
        bookRepository.saveAndFlush(book);
        return book;
    }

    @Transactional
    @Override
    public Book update(Book book) {
        if (isBook(book) && !Objects.equals(book.getId(), findByName(book.getName()).getId())) {
            Author author = authorService.getById(book.getAuthor().getId());
            throw new EntityNotCreateException(String.format(
                    "The book name=%s by author with name=%s and surname=%s already exists.", book.getName(), author.getName(), author.getSurname()));
        }
        return bookRepository.saveAndFlush(book);
    }

    @Transactional
    @Override
    public List<Book> getAll() {
        List<Book> bookList = bookRepository.findAll();
        if (CollectionUtils.isEmpty(bookList)) {
            throw new EntityNotFoundException("There are no books to represent");
        }
        return bookList;
    }

    @Override
    public Page<Book> getAllPaginated(Pageable pageable) {
        Page<Book> page = null;
        try {
            page = bookRepository.findAll(pageable);
        } catch (Exception e) {
            throw new EntityNotFoundException("Fieldname incorrect");
        }
        return page;
    }

    @Transactional
    @Override
    public Book findByName(String name) {
        return bookRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Book with name=%s not found", name)));
    }

    @Override
    public boolean isBook(Book book) {
        return bookRepository.existsBookByNameAndYearAndAuthor(book.getName(), book.getYear(), book.getAuthor());
    }

    @Override
    public Page<Book> findBookByGenreOrAll(String genre, Pageable pageable) {
        Page<Book> page = null;
        if (genre.equals("all")) {
            page = bookRepository.findAll(pageable);
        } else {
            try {
                page = bookRepository.findBookByGenreBook(genre, pageable);
            } catch (Exception e) {
                throw new EntityNotFoundException("The search data is incorrect");
            }
        }
        return page;
    }
}
