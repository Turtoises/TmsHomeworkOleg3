package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.AbstractEntity;

import java.sql.SQLException;
import java.util.List;

public interface Repository<E extends AbstractEntity> {

    boolean deleteById(Long id) throws SQLException;

    E getById(Long id) throws SQLException;

    boolean create(E entity) throws SQLException;

    boolean update(E entity);

    List<E> getAll();

}
