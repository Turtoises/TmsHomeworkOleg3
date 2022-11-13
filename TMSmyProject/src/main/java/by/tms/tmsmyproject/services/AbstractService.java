package by.tms.tmsmyproject.services;

import by.tms.tmsmyproject.entities.AbstractEntity;
import by.tms.tmsmyproject.repositories.AbstractRepository;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractService <E extends AbstractEntity,R extends AbstractRepository<E>> implements CrudService<E>{

    protected R repository;

    protected HttpServletRequest request;

}
