package by.tms.tmsmyproject.repositories.impl;

import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.exception.UserHibernateRepositoryException;
import by.tms.tmsmyproject.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserHibernateRepositoryIml implements UserRepository {

    private final SessionFactory sessionFactory;

    @Override
    public User deleteById(Long id) {
        User user;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, id);
            session.delete(user);
        }
        return user;
    }

    @Override
    public User getById(Long id) {
        User user;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, id);
        }
        return user;
    }

    @Override
    public User create(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.save(user);
        } catch (Exception e) {
            throw new UserHibernateRepositoryException("Can't save user");
        }
        return user;
    }

    @Override
    public User update(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.update(user);
        } catch (Exception e) {
            throw new UserHibernateRepositoryException("Can't update user");
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users;
        try (Session session = sessionFactory.openSession()) {
            users = session.createQuery("FROM User").getResultList();
        }
        return users;
    }

    @Override
    public boolean isUserId(Long id) {
        Long count = 0L;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("SELECT COUNT (user) FROM User user WHERE user.id= :id");
            query.setParameter("id", id);
            count = (Long) query.getSingleResult();
        }
        return count > 0;
    }

    @Override
    public boolean isUserLogin(String login) {
        Long count = 0L;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("SELECT COUNT (user) FROM User user WHERE user.login= :login");
            query.setParameter("login", login);
            count = (Long) query.getSingleResult();
        }
        return count > 0;
    }

    @Override
    public boolean isUserEmail(String email) {
        Long count = 0L;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("SELECT COUNT (user) FROM User user WHERE user.email= :email");
            query.setParameter("email", email);
            count = (Long) query.getSingleResult();
        }
        return count > 0;
    }
}



