package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.Author;

import java.sql.SQLException;

public interface AuthorRepository extends Repository<Author> {

    public boolean isAuthor(Author author) throws SQLException;
}
