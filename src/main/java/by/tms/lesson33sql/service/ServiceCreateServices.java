package by.tms.lesson33sql.service;

import by.tms.lesson33sql.repositories.CityRepository;
import by.tms.lesson33sql.repositories.CityRepositoryImpl;
import by.tms.lesson33sql.repositories.StudentRepository;
import by.tms.lesson33sql.repositories.StudentRepositoryImpl;

import java.nio.file.Path;

public class ServiceCreateServices {

    public ServiceCityImpl serviceCityImpl;
    public ServiceStudentImpl serviceStudentImpl;
    private CityRepository cityRepositoryIml;
    private StudentRepository studentRepositoryImpl;

    public ServiceCreateServices(Path databasePropertiesFilePath) {
        cityRepositoryIml = new CityRepositoryImpl(databasePropertiesFilePath);
        studentRepositoryImpl = new StudentRepositoryImpl(databasePropertiesFilePath);
        serviceCityImpl = new ServiceCityImpl(cityRepositoryIml);
        serviceStudentImpl = new ServiceStudentImpl(cityRepositoryIml, studentRepositoryImpl);
    }
}
