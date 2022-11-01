package by.tms.lesson32solid.repositories;

import by.tms.lesson32solid.entities.User;

public interface UserRepository extends Repository<User>{

    User findByLogin(Object obj);

    boolean isUser(String login);

    public void add(User unit);

}
