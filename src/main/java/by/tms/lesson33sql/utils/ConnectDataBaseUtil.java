package by.tms.lesson33sql.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

@Slf4j
public final class ConnectDataBaseUtil {

    private ConnectDataBaseUtil() {
    }

    public static Connection getConnection(Path pathFileProperties) throws SQLException, IOException {

        Properties properties = new Properties();

        try (InputStream in = Files.newInputStream(pathFileProperties)) {
            properties.load(in);
        }

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}
