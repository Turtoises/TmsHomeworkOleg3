package by.tms.tmsmyproject.controllers;

import by.tms.tmsmyproject.utils.ConnectDataBaseSingletonUtil;
import by.tms.tmsmyproject.utils.Constants;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@WebListener
public class ListenerContext implements ServletContextListener {

    private static Connection connection;

    public ListenerContext() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            connection = ConnectDataBaseSingletonUtil.getConnection();
        } catch (SQLException e) {
            log.warn("SQLException connect {}", e.getMessage());
        } catch (ClassNotFoundException e) {
            log.warn("ClassNotFoundException connect {}", e.getMessage());
        }

        ServletContext servletContext = sce.getServletContext();
        if (connection != null) {
            servletContext.setAttribute(Constants.CONTEXT_ATTRIBUTE_IS_CONNECT, true);
            log.debug("Connection is right");
        } else {
            servletContext.setAttribute(Constants.CONTEXT_ATTRIBUTE_IS_CONNECT, false);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            connection.close();
            log.debug("Connection close");
        } catch (SQLException e) {
            log.warn("SQLException close connect {}", e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
