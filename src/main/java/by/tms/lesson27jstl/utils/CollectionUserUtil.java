package by.tms.lesson27jstl.utils;

import by.tms.lesson27jstl.pojo.UserDate;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CollectionUserUtil {

    private CollectionUserUtil() {
    }

    public static List<UserDate> initCollectionUser() {
        List<UserDate> userDates = new ArrayList<>(Arrays.asList(
                new UserDate("Ivan", "Petrov", Status.STUDENT),
                new UserDate("Petr", "Ivanov", Status.STUDENT),
                new UserDate("Fedr", "Krilov", Status.TEACHER)
        ));

        return userDates;
    }

    public static void destroyCollectionUser(List<UserDate> userDates) {
        if (userDates != null) {
            userDates.clear();
        }
    }

    public static void addUserToServer(UserDate userDate, HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute(Contants.ATTRIBUTE_IS_ADDED_USER, false);

        if (userDate != null) {
            List<UserDate> userDateList = getUserListIntoContext(request);
            userDateList.add(userDate);
            servletContext.setAttribute(Contants.ATTRIBUTE_USERS_LIST, userDateList);
            servletContext.setAttribute(Contants.ATTRIBUTE_ADDED_USER, userDate);
            servletContext.setAttribute(Contants.ATTRIBUTE_IS_ADDED_USER, true);
        }
    }

    public static boolean deleteUserIntoServer(UserDate userDate, HttpServletRequest request) {
        if (userDate == null) {
            return false;
        }
        ServletContext servletContext = request.getServletContext();

        if (userDate != null) {
            List<UserDate> userDateList = getUserListIntoContext(request);
            if (userDateList.remove(userDate)) {
                servletContext.setAttribute(Contants.ATTRIBUTE_USERS_LIST, userDateList);
                servletContext.setAttribute(Contants.ATTRIBUTE_DELETED_USER, userDate);
                return true;
            }
        }
        return false;
    }

    public static boolean isUsersListEmptyOrNull(HttpServletRequest request) {
        List<UserDate> userDateList = getUserListIntoContext(request);

        return (userDateList.isEmpty() || userDateList == null);
    }

    public static boolean isUserThisStatus(HttpServletRequest request, Status status) {
        List<UserDate> userDateList = getUserListIntoContext(request);
        for (UserDate user : userDateList) {
            if (user.getStatus().equals(status)) {
                return true;
            }
        }
        return false;
    }

    public static List<UserDate> getUserListIntoContext(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        List<UserDate> userDateList = (ArrayList<UserDate>) servletContext.getAttribute(Contants.ATTRIBUTE_USERS_LIST);
        return userDateList;
    }
}
