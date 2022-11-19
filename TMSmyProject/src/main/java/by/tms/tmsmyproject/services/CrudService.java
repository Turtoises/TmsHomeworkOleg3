package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.AbstractEntity;

import java.util.List;

public interface CrudService <E extends AbstractEntity,R> {

    R deleteById(Long id);

    R delete(E entity);

    R getById(Long id);

    R create(E entity);

    R update(E entity);

    List<E> getAll();

}
