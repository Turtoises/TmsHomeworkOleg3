package by.tms.lesson29сollection.task3.utils;

import by.tms.lesson29сollection.task3.pojo.UserInformation;

import java.util.Arrays;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

public final class UserСacheUtils {

    private static WeakHashMap<UserInformation, Object> cacheUser = new WeakHashMap<>();

    private UserСacheUtils() {
    }

    public static void addIntoCache(UserInformation... users) {

        for (int i = 0; i < users.length; i++) {
            cacheUser.put(users[i], new Object());
        }
    }


    public static int getAmountCache() {
        return cacheUser.size();
    }


}
