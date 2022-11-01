package by.tms.lesson32solid.repositories;

public interface Repository<T> {

    void delete(Object obj);

    boolean isEpty();

}
