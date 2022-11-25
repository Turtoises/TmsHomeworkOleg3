package by.tms.tmsmyproject.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class StatementUtil {

    private StatementUtil() {
    }

    public static PreparedStatement getPreparedStatement(Connection connection, String statement, Object... arguments) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(statement);
        for (int i = 0; i < arguments.length; i++) {
            Object argument = arguments[i];
            if (argument instanceof Integer) {
                ps.setInt(i + 1, (Integer) argument);
                continue;
            }
            if (argument instanceof String) {
                ps.setString(i + 1, (String) argument);
                continue;
            }
            if (argument instanceof Long) {
                ps.setLong(i + 1, (Long) argument);
                continue;
            }
        }
        return ps;
    }
}

