package by.tms.lesson22.task2;

import java.util.HashMap;
import java.util.Map;

public final class UserPasswordMap {

    private static Map<String, String> userDate = new HashMap<>();

    private static void addDate(){
        userDate.put("oleg", "12345");
    }

    public static Map<String, String> getUserDate() {
        addDate();

        return userDate;
    }
}

