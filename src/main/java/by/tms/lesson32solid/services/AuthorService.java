package by.tms.lesson32solid.services;

import by.tms.lesson32solid.entities.Author;

import java.util.Set;

public interface AuthorService extends Service {

    boolean addBook(String firstName, String lastName, String book);

    boolean deleteBook(String firstName, String lastName, String book);

    boolean deleteAuthor(String firstName, String lastName);

    boolean isAuthor(Author author);

    boolean isBook(String firstName, String lastName, String book);

    Set<String> getAllAuthorBooks(String firstName, String lastName);


}
