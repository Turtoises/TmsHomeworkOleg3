package by.tms.lesson32solid.repositories;

import by.tms.lesson32solid.entities.Author;

import java.util.*;

public class AuthorRepositoryIml implements AuthorRepository<Author> {

    private Map<Author, Set<String>> authorReposit;

    public AuthorRepositoryIml() {
        this.authorReposit = init();
    }

    @Override
    public boolean isAuthor(Author author) {
        return authorReposit.containsKey(author);
    }

    @Override
    public Set<String> getBooks(Author author) {
        return authorReposit.get(author);
    }

    public Map<Author, Set<String>> init() {
        Map<Author, Set<String>> authors = new HashMap<>();

        Author author1 = new Author("Aleksandr", "Pushkin");
        Author author2 = new Author("Lev", "Tolstoi");

        authors.put(author1, new HashSet<>(Arrays.asList("Metelica", "Byra")));
        authors.put(author2, new HashSet<>(Arrays.asList("Voina i mir")));

        return authors;
    }

    @Override
    public void add(Author author, Set<String> books) {
        authorReposit.put(author, books);
    }

    @Override
    public void delete(Object obj) {
        authorReposit.remove(obj);
    }

    @Override
    public boolean isEpty() {
        return authorReposit.isEmpty();
    }
}
