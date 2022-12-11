package by.tms.tmsmyproject.repositories;

import by.tms.tmsmyproject.entities.AbstractEntity;

import java.util.List;

public interface CrudRepository<E extends AbstractEntity> {

    boolean deleteById(Long id);

    E getById(Long id);

    boolean create(E entity);

    boolean update(E entity);

    List<E> getAll();

}
