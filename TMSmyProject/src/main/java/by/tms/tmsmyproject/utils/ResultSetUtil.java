package by.tms.tmsmyproject.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ResultSetUtil {

    private ResultSetUtil() {
    }

    public static boolean isResult(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            return false;
        }
        return resultSet.next();
    }
}
