package by.tms.lesson36Pattern2.task2singleton;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class ConnectDataBaseSingletonUtil {

    private static Connection connection;

    private ConnectDataBaseSingletonUtil() {
    }

    public static Connection getConnection(Path pathFileProperties) throws SQLException, IOException {

        if (connection == null) {
            Properties properties = new Properties();

            try (InputStream in = Files.newInputStream(pathFileProperties)) {
                properties.load(in);
            }

            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            return DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}

