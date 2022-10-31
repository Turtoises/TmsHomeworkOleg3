package by.tms.lesson31log.task2.utils;

import by.tms.lesson31log.task2.pogo.User;

import java.util.*;

public final class MapUserUtil {

    private static Map<Long, User> userMap = getUserMap();

    private MapUserUtil() {
    }

    private static Map<Long, User> getUserMap() {
        Map<Long, User> userMap = new HashMap<>();
        userMap.put(12345L, new User("Ivan", 12345));
        userMap.put(1890L, new User("Maria", 1890));
        userMap.put(1567L, new User("Tana", 1567));

        return userMap;
    }

    public static boolean isUser(long userID) {

        return userMap.containsKey(userID);
    }

    public static User getUser(long userID) {
        return userMap.get(userID);
    }

    public static boolean isListUserEmpty() {
        return (userMap.isEmpty() || userMap == null);
    }

    public static void setUserMap(Map<Long, User> userMap) {
        MapUserUtil.userMap = userMap;
    }
}
