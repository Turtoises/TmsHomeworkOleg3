package by.tms.lesson27jstl.listener;

import by.tms.lesson27jstl.utils.Contants;
import by.tms.lesson27jstl.pojo.UserDate;
import by.tms.lesson27jstl.utils.CollectionUserUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ListenerUsersCourse implements ServletContextListener {

    public ListenerUsersCourse() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute(Contants.ATTRIBUTE_USERS_LIST, CollectionUserUtil.initCollectionUser());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        CollectionUserUtil.destroyCollectionUser((List<UserDate>) servletContext.getAttribute(Contants.ATTRIBUTE_USERS_LIST));
    }

}
