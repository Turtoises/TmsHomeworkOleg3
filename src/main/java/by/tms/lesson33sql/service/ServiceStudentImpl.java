package by.tms.lesson33sql.service;

import by.tms.lesson33sql.entities.City;
import by.tms.lesson33sql.entities.Student;
import by.tms.lesson33sql.repositories.CityRepository;
import by.tms.lesson33sql.repositories.StudentRepository;
import by.tms.lesson33sql.utils.FindNullUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class ServiceStudentImpl {

    private static Logger logger = LoggerFactory.getLogger("ServiceStudentImpl");

    CityRepository cityRepository;
    StudentRepository studentRepository;

    public ServiceStudentImpl(CityRepository cityRepository, StudentRepository studentRepository) {
        this.cityRepository = cityRepository;
        this.studentRepository = studentRepository;
    }

    public boolean add(String name, String surname, String city) {
        if (FindNullUtils.isAnyNull(name, surname, city)) {
            return false;
        }
        int index = cityRepository.getID(new City(0, city));
        if (index == 0) {
            logger.info("City not find");
            return false;
        }
        boolean isAdd = studentRepository.add(new Student(0, name, surname, index));
        logger.info("Add is {}", isAdd);
        return isAdd;
    }

    public boolean delete(Integer id) {
        if (id == null || id <= 0) {
            logger.info("Wrong id");
            return false;
        }
        boolean isDelete = studentRepository.delete(id);
        logger.info("Delete student {}", isDelete);

        return isDelete;
    }

    public void printInf(String statement) {
        if (statement == null || statement.isEmpty()) {
            logger.info("Wrong statement");
        }
        try (ResultSet resultSet = studentRepository.getResulSet(statement)) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String city = resultSet.getString("city");
                System.out.println(name + " " + surname + " " + city);
            }
        } catch (SQLException e) {
            logger.debug(e.getMessage());
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }
    }
}
