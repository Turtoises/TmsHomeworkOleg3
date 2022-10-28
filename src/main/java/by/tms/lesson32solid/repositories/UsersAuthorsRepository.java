package by.tms.lesson32solid.repositories;

import by.tms.lesson32solid.entities.UserAuthor;

public interface UsersAuthorsRepository<T,U> extends Repository<T> {

    T findByLogin(Object obj);

    boolean isUser(String login);

    U getBooks(String login);

    public void add(UserAuthor userAuthor);
}
