package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.AbstractEntity;

import java.util.List;

public interface CrudService <E extends AbstractEntity> {

    E deleteById(Long id);

    boolean delete(E entity);

    E getById(Long id);

    E create(E entity);

   E update(E entity);

    List<E> getAll();

}
