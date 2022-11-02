package by.tms.lesson33sql.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public final class RepositoryImplUtil {

    private static Logger logger = LoggerFactory.getLogger("RepositoryImplUtil");

    private RepositoryImplUtil() {
    }

    public static boolean deleteWithID(Path databasePropertiesFilePath, String deleteStatement, Integer id) {

        boolean isDelete = false;

        try (Connection connection = ConnectDataBaseUtil.getConnection(databasePropertiesFilePath)) {
            PreparedStatement ps = connection.prepareStatement(deleteStatement);
            ps.setInt(1, id);
            int line = ps.executeUpdate();
            isDelete = line > 0;
        } catch (SQLException e) {
            log.debug(e.getMessage());
        } catch (IOException e) {
            log.debug(e.getMessage());
        }

        return isDelete;
    }
}
