package by.tms.lesson24.task1;

import java.util.ArrayList;
import java.util.List;

public final class UseList {
    private static List<User> userList = new ArrayList<>();

    private UseList() {

    }

    public static void addUserIntoList(String firstName, String lastName,
                                       String language, String gender, String[] programmingLanguage,
                                       String additionalInformation, String password) {
        userList.add(new User(firstName, lastName,
                language, gender, programmingLanguage,
                additionalInformation, password));
    }

    public static List<User> getUserList() {
        return userList;
    }
}
