package by.tms.lesson26jsp.listener;

import by.tms.lesson26jsp.pojo.UserDate;
import by.tms.lesson26jsp.utils.Contants;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ListenerFormUsers implements ServletContextListener {

    public ListenerFormUsers() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute(Contants.USER_ATTRIBUTE, initCollection());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        destroyCollection((List<String>) servletContext.getAttribute(Contants.USER_ATTRIBUTE));
    }

    private List<UserDate> initCollection() {
        List<UserDate> userDates = new ArrayList<>();

        return userDates;
    }

    private void destroyCollection(List<String> userDates) {
        userDates.clear();
    }
}
