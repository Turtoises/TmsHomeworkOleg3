package by.tms.lesson33sql.repositories;

import by.tms.lesson33sql.entities.Student;
import by.tms.lesson33sql.utils.ConnectDataBaseUtil;
import by.tms.lesson33sql.utils.Constants;
import by.tms.lesson33sql.utils.RepositoryImplUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

    private static Logger logger = LoggerFactory.getLogger("StudentRepositoryImpl");

    private Path databasePropertiesFilePath;

    public StudentRepositoryImpl(Path databasePropertiesFilePath) {
        this.databasePropertiesFilePath = databasePropertiesFilePath;
    }

    @Override
    public boolean add(Student unit) {
        String name = unit.getName();
        String surname = unit.getSurname();
        Integer cityID = unit.getCityID();

        boolean isAdd = false;

        try (Connection connection = ConnectDataBaseUtil.getConnection(databasePropertiesFilePath)) {
            PreparedStatement ps = connection.prepareStatement(Constants.INSERT_STUDENT_STATEMENT);
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setInt(3, cityID);

            int line = ps.executeUpdate();
            isAdd = line > 0;
        } catch (SQLException e) {
            logger.debug(e.getMessage());
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }
        return isAdd;
    }

    @Override
    public boolean delete(Integer id) {

        boolean isDelete = RepositoryImplUtil.deleteWithID(databasePropertiesFilePath, Constants.DELETE_STUDENT_STATEMENT, id);

        return isDelete;
    }

    public ResultSet getResulSet(String statement) throws SQLException, IOException {
        ResultSet resultSet = null;
        Connection connection = ConnectDataBaseUtil.getConnection(databasePropertiesFilePath);
        PreparedStatement ps = connection.prepareStatement(statement);
        resultSet = ps.executeQuery();
        return resultSet;
    }
}
