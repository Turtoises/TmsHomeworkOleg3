package by.tms.lesson33sql.service;

import by.tms.lesson33sql.entities.City;
import by.tms.lesson33sql.entities.Student;
import by.tms.lesson33sql.repositories.CityRepository;
import by.tms.lesson33sql.repositories.CityRepositoryImpl;
import by.tms.lesson33sql.repositories.StudentRepository;
import by.tms.lesson33sql.repositories.StudentRepositoryImpl;
import by.tms.lesson33sql.utils.FindNullUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class ServiceStudentImpl {

    CityRepository cityRepository;
    StudentRepository studentRepository;

    public ServiceStudentImpl(Path databasePropertiesFilePath) {
        this.cityRepository = new CityRepositoryImpl(databasePropertiesFilePath);
        this.studentRepository = new StudentRepositoryImpl(databasePropertiesFilePath);
    }

    public boolean add(String name, String surname, String city) {
        if (FindNullUtils.isAnyNull(name, surname, city)) {
            return false;
        }
        int index = cityRepository.getID(new City(0, city));
        if (index == 0) {
            log.info("City not find");
            return false;
        }
        boolean isAdd = studentRepository.add(new Student(0, name, surname, index));
        log.info("Add is {}", isAdd);
        return isAdd;
    }

    public boolean delete(Integer id) {
        if (id == null || id <= 0) {
            log.info("Wrong id");
            return false;
        }
        boolean isDelete = studentRepository.delete(id);
        log.info("Delete student {}", isDelete);

        return isDelete;
    }

    public void printInf(String statement) {
        if (statement == null || statement.isEmpty()) {
            log.info("Wrong statement");
        }
        try (ResultSet resultSet = studentRepository.getResulSet(statement)) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String city = resultSet.getString("city");
                log.info("Name {},surname {}, city{} ", name, surname, city);
            }
        } catch (SQLException e) {
            log.debug(e.getMessage());
        } catch (IOException e) {
            log.debug(e.getMessage());
        }
    }
}
