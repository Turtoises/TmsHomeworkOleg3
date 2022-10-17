package by.tms.lesson28ClassObject.task3.utils;

import by.tms.lesson28ClassObject.task1.Adress;
import by.tms.lesson28ClassObject.task1.Gender;
import by.tms.lesson28ClassObject.task1.User;

import java.util.HashMap;
import java.util.Map;

public final class UserMapUtil {

    private UserMapUtil() {
    }

    public static Map<Integer, User> getMapUser() {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("Ivan", "Ivanov", 18, Gender.MAN,
                new Adress("Lenina", 20, 8)));
        userMap.put(2, new User("Fedr", "Ivanov", 22, Gender.MAN,
                new Adress("Lenina", 25, 1)));
        userMap.put(3, new User("Tana", "Petrova", 27, Gender.WOMAN,
                new Adress("Sloboda", 25, 5)));

        return userMap;
    }
}
