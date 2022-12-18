package by.tms.tmsmyproject.repositories.impl;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.repositories.UserRepository;
import by.tms.tmsmyproject.utils.constants.ConstantsStatement;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepositoryIml implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public boolean deleteById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM User user WHERE user.id= :id");
        query.setParameter("id", id);
        int row = query.executeUpdate();
        return row != 0;
    }

    @Override
    public User getById(Long id) {
        Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.id= :id");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

    @Transactional
    @Override
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("SELECT user FROM User user");
        return (List<User>) query.getResultList();
    }

    @Override
    public User getByLogin(String login) {
        Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.login= :login");
        query.setParameter("login", login);
        return (User) query.getSingleResult();
    }

    @Override
    public boolean isUserId(Long id) {
        Query query = entityManager.createQuery("SELECT COUNT (user) FROM User user WHERE user.id= :id");
        query.setParameter("id", id);
        return (Long) query.getSingleResult() > 0;
    }

    @Override
    public boolean isUserLogin(String login) {
        Query query = entityManager.createQuery("SELECT COUNT (user) FROM User user WHERE user.login= :login");
        query.setParameter("login", login);
        return (Long) query.getSingleResult() > 0;
    }

    @Override
    public boolean isUserEmail(String email) {
        Query query = entityManager.createQuery("SELECT COUNT (user) FROM User user WHERE user.email= :email");
        query.setParameter("email", email);
        return (Long) query.getSingleResult() > 0;
    }
}



