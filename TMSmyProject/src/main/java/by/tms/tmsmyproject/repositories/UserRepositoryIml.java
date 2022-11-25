package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.controllers.ListenerContext;
import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.enums.RoleUser;
import by.tms.tmsmyproject.utils.ConstantsStatement;
import by.tms.tmsmyproject.utils.ResultSetUtil;
import by.tms.tmsmyproject.utils.StatementUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class UserRepositoryIml extends AbstractRepository implements UserRepository {

    public UserRepositoryIml() {
        this.connection = ListenerContext.getConnection();
    }

    @Override
    public boolean deleteById(Long id) throws SQLException {
        int row = 0;

        PreparedStatement ps = StatementUtil.getPreparedStatement(connection, ConstantsStatement.DELETE_USER_BY_ID, id);
        row = ps.executeUpdate();

        return row != 0;
    }

    @Override
    public User getById(Long id) throws SQLException {
        User user = new User();

        PreparedStatement ps = StatementUtil.getPreparedStatement(connection, ConstantsStatement.SELECT_USER_BY_ID, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user = getUserFromResultSet(rs);
        }
        return user;
    }

    @Override
    public boolean create(User user) throws SQLException {
        int row = 0;

        PreparedStatement ps = StatementUtil.getPreparedStatement(connection, ConstantsStatement.INSERT_USER, user.getArrayFields());
        row = ps.executeUpdate();
        return row != 0;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean deleteByLogin(String login) throws SQLException {
        int row = 0;

        PreparedStatement ps = StatementUtil.getPreparedStatement(connection, ConstantsStatement.DELETE_USER_BY_LOGIN, login);
        row = ps.executeUpdate();
        return row != 0;
    }

    @Override
    public User getByLogin(String login) throws SQLException {
        User user = new User();
        PreparedStatement ps = StatementUtil.getPreparedStatement(connection, ConstantsStatement.SELECT_USER_BY_LOGIN, login);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user = getUserFromResultSet(rs);
        }
        return user;
    }

    @Override
    public boolean isUserLogin(String login) throws SQLException {
        PreparedStatement ps = StatementUtil.getPreparedStatement(connection, ConstantsStatement.SELECT_USER_BY_LOGIN, login);

        return ResultSetUtil.isResult(ps.executeQuery());
    }

    @Override
    public boolean isUserEmail(String email) throws SQLException {
        PreparedStatement ps = StatementUtil.getPreparedStatement(connection, ConstantsStatement.SELECT_USER_BY_EMAIL, email);

        return ResultSetUtil.isResult(ps.executeQuery());
    }

    private User getUserFromResultSet(ResultSet rs) throws SQLException {

        return User.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .password(rs.getString("password"))
                .login(rs.getString("login"))
                .email(rs.getString("email"))
                .userRole(RoleUser.valueOf(rs.getString("role").toUpperCase()))
                .build();
    }

}



