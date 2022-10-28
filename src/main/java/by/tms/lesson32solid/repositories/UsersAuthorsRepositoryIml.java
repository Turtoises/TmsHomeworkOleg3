package by.tms.lesson32solid.repositories;

import by.tms.lesson32solid.entities.Author;
import by.tms.lesson32solid.entities.UserAuthor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsersAuthorsRepositoryIml implements UsersAuthorsRepository<UserAuthor, Map<Author, Set<String>>> {
    private Map<String, UserAuthor> userAuthorRep;

    public UsersAuthorsRepositoryIml() {
        this.userAuthorRep = init();
    }

    public Map<String, UserAuthor> init() {
        return new HashMap<>();
    }

    @Override
    public void add(UserAuthor userAuthor) {
        userAuthorRep.put(userAuthor.getLogin(), userAuthor);
    }

    @Override
    public void delete(Object obj) {
        userAuthorRep.remove(obj);
    }

    @Override
    public boolean isEpty() {
        return userAuthorRep.isEmpty();
    }

    @Override
    public UserAuthor findByLogin(Object obj) {
        return userAuthorRep.get(obj);
    }

    @Override
    public boolean isUser(String login) {
        return userAuthorRep.containsKey(login);
    }

    @Override
    public Map<Author, Set<String>> getBooks(String login) {
        return userAuthorRep.get(login).getUserAuthor();
    }
}
