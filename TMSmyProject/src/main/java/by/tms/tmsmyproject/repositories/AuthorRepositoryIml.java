package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.controllers.ListenerContext;
import by.tms.tmsmyproject.entities.Author;
import by.tms.tmsmyproject.utils.ConstantsStatement;
import by.tms.tmsmyproject.utils.ResultSetUtil;
import by.tms.tmsmyproject.utils.StatementUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AuthorRepositoryIml extends AbstractRepository implements AuthorRepository {

    public AuthorRepositoryIml() {
        this.connection = ListenerContext.getConnection();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Author getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public boolean create(Author author) throws SQLException {
        int row = 0;

        PreparedStatement ps = StatementUtil.getPreparedStatement(connection, ConstantsStatement.INSERT_AUTHOR, author.getArrayFields());
        row = ps.executeUpdate();
        return row != 0;
    }

    @Override
    public boolean update(Author entity) {
        return false;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public boolean isAuthor(Author author) throws SQLException {
        PreparedStatement ps = StatementUtil.getPreparedStatement(
                connection, ConstantsStatement.SELECT_AUTHOR_BY_NAME, author.getName(), author.getSurname());
        return ResultSetUtil.isResult(ps.executeQuery());
    }
}
