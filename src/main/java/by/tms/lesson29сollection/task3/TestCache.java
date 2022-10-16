package by.tms.lesson29сollection.task3;

import by.tms.lesson29сollection.task3.pojo.UserInformation;
import by.tms.lesson29сollection.task3.utils.UserСacheUtils;

public class TestCache {

    public static void main(String[] args) throws InterruptedException {

        UserInformation user1 = new UserInformation("Nik", "Petrov", 111);
        UserInformation user2 = new UserInformation("Leon", "Ivanov", 333);
        UserInformation user3 = new UserInformation("Gai", "Petrov", 222);

        UserСacheUtils.addIntoCache(user1, user2, user3);

        System.out.println(UserСacheUtils.getAmountCache());

        user1 = null;

        System.gc();

        Thread.sleep(300);

        System.out.println(UserСacheUtils.getAmountCache());

    }
}
