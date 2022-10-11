package by.tms.lesson28ClassObject.task3;

import by.tms.lesson28ClassObject.task1.Adress;
import by.tms.lesson28ClassObject.task1.Gender;
import by.tms.lesson28ClassObject.task1.User;
import by.tms.lesson28ClassObject.task3.utils.TypeClone;
import by.tms.lesson28ClassObject.task3.utils.UserCloneUtil;
import by.tms.lesson28ClassObject.task3.utils.UserMapUtil;

import java.util.Map;

public class TestClone {

    public static void main(String[] args) throws CloneNotSupportedException {

        Map<Integer, User> userMap = UserMapUtil.getMapUser();

        System.out.println("DEEP CLONE");
        User userID1 = userMap.get(1);
        User userClone = UserCloneUtil.getClone(TypeClone.DEEP, 1, userMap).orElse(new User(null, null, 0, Gender.MAN, null));

        System.out.println(userID1);
        System.out.println(userClone);

        System.out.println("------------------------");

        userID1.setAdress(new Adress("Vasykova", 30, 7));

        System.out.println(userID1);
        System.out.println(userClone);

        System.out.println("------------------------");

        System.out.println("SHALLOW CLONE");

        User userClone2 = UserCloneUtil.getClone(TypeClone.SHALLOW, 1, userMap).orElse(new User(null, null, 0, Gender.MAN, null));
        System.out.println(userID1);
        System.out.println(userClone2);

        userID1.setAdress(new Adress("Jdanova", 25, 7));

        System.out.println(userID1);
        System.out.println(userClone2);

    }
}
