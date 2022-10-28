package by.tms.lesson32solid.services;

import by.tms.lesson32solid.entities.Author;
import by.tms.lesson32solid.repositories.AuthorRepository;
import by.tms.lesson32solid.utils.FindNullUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private static Logger logger = LoggerFactory.getLogger("AuthorServiceImpl");

    private AuthorRepository authorRep;

    public AuthorServiceImpl(AuthorRepository authorRep) {
        this.authorRep = authorRep;
    }

    @Override
    public boolean addBook(String firstName, String lastName, String book) {

        if (FindNullUtils.isAnyNull(firstName, lastName, book)) {
            return false;
        }

        Author author = create(firstName, lastName);
        boolean isAdd = false;

        if (isAuthor(author)) {
            Set<String> newbooks = getAllAuthorBooks(firstName, lastName);
            isAdd = newbooks.add(book);
            authorRep.add(author, newbooks);
        } else {
            authorRep.add(author, new HashSet<>(Arrays.asList(book)));
            isAdd = true;
        }
        logger.info("Add book {}", isAdd);
        return isAdd;
    }

    @Override
    public boolean deleteBook(String firstName, String lastName, String book) {

        if (FindNullUtils.isAnyNull(firstName, lastName, book)) {
            return false;
        }

        Author author = create(firstName, lastName);
        boolean isDelete = false;

        if (isAuthor(author)) {
            Set<String> books = getAllAuthorBooks(firstName, lastName);
            isDelete = books.remove(book);
            if (books.isEmpty()) {
                authorRep.delete(author);
            } else {
                authorRep.add(author, books);
            }
        }
        logger.info("Delete book {}", isDelete);
        return isDelete;
    }

    @Override
    public boolean deleteAuthor(String firstName, String lastName) {
        if (FindNullUtils.isAnyNull(firstName, lastName)) {
            return false;
        }

        Author author = create(firstName, lastName);

        if (isAuthor(author)) {
            authorRep.delete(author);
            logger.info("Delete author {}", true);
            return true;
        }
        return false;
    }

    @Override
    public boolean isAuthor(Author author) {
        if (FindNullUtils.isAnyNull(author)) {
            return false;
        }

        return !authorRep.isEpty() && authorRep.isAuthor(author);
    }

    @Override
    public boolean isBook(String firstName, String lastName, String book) {
        if (FindNullUtils.isAnyNull(firstName, lastName, book)) {
            return false;
        }

        Author author = create(firstName, lastName);
        boolean isBook = false;

        if (isAuthor(author)) {
            Set<String> books = getAllAuthorBooks(firstName, lastName);
            isBook = books.contains(book);
            return isBook;
        }
        return isBook;
    }

    @Override
    public Set<String> getAllAuthorBooks(String firstName, String lastName) {
        Set<String> books = new HashSet<>();
        if (FindNullUtils.isAnyNull(firstName, lastName)) {
            return books;
        }

        Author author = create(firstName, lastName);

        if (isAuthor(author)) {
            books = authorRep.getBooks(author);
            return books;
        }
        logger.info("No author found");
        return books;
    }

    @Override
    public boolean isEmpty() {
        return authorRep.isEpty();
    }

    public Author create(String firstName, String lastName) {
        return new Author(firstName, lastName);
    }

}
