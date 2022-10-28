package by.tms.lesson32solid.repositories;

import by.tms.lesson32solid.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryIml implements UserRepository {
    private Map<String, User> userReposit;

    public UserRepositoryIml() {
        this.userReposit = init();
    }

    public Map<String, User> init() {
        Map<String, User> initUserReposit = new HashMap<>();

        initUserReposit.put("german", new User("german", "12345"));
        initUserReposit.put("ivan", new User("ivan", "1234578"));
        initUserReposit.put("mana", new User("mana", "12345ghy"));

        return initUserReposit;
    }

    public void add(User unit) {
        userReposit.put(unit.getLogin(), unit);
    }

    @Override
    public void delete(Object obj) {
        userReposit.remove(obj);
    }

    @Override
    public boolean isEpty() {
        return userReposit.isEmpty();
    }

    @Override
    public User findByLogin(Object obj) {
        return userReposit.get(obj);
    }

    @Override
    public boolean isUser(String login) {
        return userReposit.containsKey(login);
    }

}
