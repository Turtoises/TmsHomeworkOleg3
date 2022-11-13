package by.tms.tmsmyproject.utils;

import by.tms.tmsmyproject.config.DataBaseConfig;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public final class ConnectDataBaseSingletonUtil {

    private static Connection connection;

    private ConnectDataBaseSingletonUtil() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        if (connection == null) {
            String url = DataBaseConfig.URL;
            String username = DataBaseConfig.USERNAME;
            String password = DataBaseConfig.PASSWORD;
            Class.forName(DataBaseConfig.DRIVER);
            return DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

}
