package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.AbstractEntity;
import by.tms.tmsmyproject.repositories.Repository;

public abstract class AbstractService<E extends AbstractEntity, R extends Repository<E>> {

    protected R repository;

}
