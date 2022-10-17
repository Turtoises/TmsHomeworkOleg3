package by.tms.lesson28ClassObject.task3.utils;

import by.tms.lesson28ClassObject.task1.Adress;
import by.tms.lesson28ClassObject.task1.User;

import java.util.Map;
import java.util.Optional;

public final class UserCloneUtil {

    private UserCloneUtil() {
    }

    public static Optional<User> getClone(TypeClone typeClone, int userID, Map<Integer, User> userMap) throws CloneNotSupportedException {
        if (userMap == null || !userMap.containsKey(userID) || userMap.get(userID) == null) {
            return Optional.empty();
        }

        User userOriginal = userMap.get(userID);
        User userCopy = userOriginal.clone();

        if (typeClone.equals(TypeClone.DEEP)) {
            Adress adressCopy = userOriginal.getAdress().clone();
            userCopy.setAdress(adressCopy);
        }

        return Optional.of(userCopy);
    }

}
