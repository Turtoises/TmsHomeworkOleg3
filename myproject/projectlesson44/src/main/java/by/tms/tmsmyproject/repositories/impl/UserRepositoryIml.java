package by.tms.tmsmyproject.repositories.impl;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.repositories.UserRepository;
import by.tms.tmsmyproject.utils.constants.ConstantsStatement;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class UserRepositoryIml implements UserRepository {

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
        int row = jdbcTemplate.update(ConstantsStatement.INSERT_USER, user.arrayFields());
        return row != 0;
    }

    @Override
    public boolean update(User user) {
        ArrayList<Object> list=new ArrayList<>(Arrays.asList(user.arrayFields()));
        list.add(user.getId());
        int row=jdbcTemplate.update(ConstantsStatement.UPDATE_USER, list.toArray());

        return row != 0;
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
    public boolean isUserId(Long id) {
        int amount = jdbcTemplate.queryForObject(ConstantsStatement.SELECT_AMOUNT_USER_BY_ID, Integer.class, id);
        return amount > 0;
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

}



