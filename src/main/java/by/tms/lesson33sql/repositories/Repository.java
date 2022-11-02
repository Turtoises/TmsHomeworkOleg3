package by.tms.lesson33sql.repositories;

public interface Repository <T> {

    boolean add(T unit);

    boolean delete(Integer id);

}
