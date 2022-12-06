package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.AbstractEntity;

import java.util.List;

public interface CrudService <E extends AbstractEntity> {

    boolean deleteById(Long id);

    boolean delete(E entity);

    E getById(Long id);

    boolean create(E entity);

    boolean update(E entity);

    List<E> getAll();

}
