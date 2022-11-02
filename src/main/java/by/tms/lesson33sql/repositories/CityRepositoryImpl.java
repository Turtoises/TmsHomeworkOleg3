package by.tms.lesson33sql.repositories;

import by.tms.lesson33sql.entities.City;
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
public class CityRepositoryImpl implements CityRepository {

    private Path databasePropertiesFilePath;

    public CityRepositoryImpl(Path databasePropertiesFilePath) {
        this.databasePropertiesFilePath = databasePropertiesFilePath;
    }

    @Override
    public boolean add(City unit) {
        String city = unit.getCity();

        boolean isAdd = false;

        try (Connection connection = ConnectDataBaseUtil.getConnection(databasePropertiesFilePath)) {
            PreparedStatement ps = connection.prepareStatement(Constants.INSERT_CITY_STATEMENT);
            ps.setString(1, city);

            int line = ps.executeUpdate();
            isAdd = line > 0;
        } catch (SQLException e) {
            log.debug(e.getMessage());
        } catch (IOException e) {
            log.debug(e.getMessage());
        }
        return isAdd;
    }

    @Override
    public boolean delete(Integer id) {
        return RepositoryImplUtil.deleteWithID(databasePropertiesFilePath, Constants.DELETE_CITY_STATEMENT, id);
    }

    @Override
    public Integer getID(City city) {
        String cityName = city.getCity();
        Integer id = 0;

        try (Connection connection = ConnectDataBaseUtil.getConnection(databasePropertiesFilePath)) {
            PreparedStatement ps = connection.prepareStatement(Constants.SELECT_CITY_STATEMENT);
            ps.setString(1, cityName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            log.debug(e.getMessage());
        } catch (IOException e) {
            log.debug(e.getMessage());
        }
        return id;
    }
}
