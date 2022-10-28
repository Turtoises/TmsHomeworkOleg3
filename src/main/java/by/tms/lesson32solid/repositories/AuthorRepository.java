package by.tms.lesson32solid.repositories;

import by.tms.lesson32solid.entities.Author;

import java.util.Set;

public interface AuthorRepository<T> extends Repository<T> {

    boolean isAuthor(T author);

    Set<String> getBooks(T author);

    public void add(Author author, Set<String> books);

}
