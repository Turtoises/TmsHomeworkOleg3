package by.tms.lesson33sql.service;

import by.tms.lesson33sql.repositories.CityRepository;
import by.tms.lesson33sql.repositories.CityRepositoryImpl;
import by.tms.lesson33sql.repositories.StudentRepository;
import by.tms.lesson33sql.repositories.StudentRepositoryImpl;

import java.nio.file.Path;

public class ServiceCreateServices {

    public ServiceCityImpl serviceCityImpl;
    public ServiceStudentImpl serviceStudentImpl;

    public ServiceCreateServices(Path databasePropertiesFilePath) {

        serviceCityImpl = new ServiceCityImpl(databasePropertiesFilePath);
        serviceStudentImpl = new ServiceStudentImpl(databasePropertiesFilePath);
    }
}
