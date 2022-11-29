package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.utils.ConstantsStatement;
import by.tms.tmsmyproject.utils.StatementUtil;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@AllArgsConstructor
public class UserRepositoryIml extends AbstractRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean deleteById(Long id) {
        int row = jdbcTemplate.update(ConstantsStatement.DELETE_USER_BY_ID, id);

        return row != 0;
    }

    @Override
    public User getById(Long id) {
        User user = jdbcTemplate.queryForObject(ConstantsStatement.SELECT_USER_BY_ID, new BeanPropertyRowMapper<>(User.class), id);

        return user == null ? new User() : user;
    }

    @Override
    public boolean create(User user) {
        int row = jdbcTemplate.update(ConstantsStatement.INSERT_USER, user.getArrayFields());
        return row != 0;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query(ConstantsStatement.SELECT_ALL_USER, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public boolean deleteByLogin(String login) {
        int row = jdbcTemplate.update(ConstantsStatement.DELETE_USER_BY_LOGIN, login);

        return row != 0;
    }

    @Override
    public User getByLogin(String login) {
        User user = jdbcTemplate.queryForObject(ConstantsStatement.SELECT_USER_BY_LOGIN, new BeanPropertyRowMapper<>(User.class), login);

        return user == null ? new User() : user;
    }

    @Override
    public boolean isUserLogin(String login) {
        int amount = jdbcTemplate.queryForObject(ConstantsStatement.SELECT_AMOUNT_USER_BY_LOGIN, Integer.class, login);

        return amount > 0;
    }

    @Override
    public boolean isUserEmail(String email) {
        int amount = jdbcTemplate.queryForObject(ConstantsStatement.SELECT_AMOUNT_USER_BY_EMAIL, Integer.class, email);

        return amount > 0;
    }

    private User getUserFromResultSet(ResultSet rs) throws SQLException {

        return User.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .password(rs.getString("password"))
                .login(rs.getString("login"))
                .email(rs.getString("email"))
                .role(rs.getString("role").toUpperCase())
                .build();
    }

}



