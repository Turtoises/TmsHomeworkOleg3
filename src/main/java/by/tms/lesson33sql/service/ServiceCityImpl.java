package by.tms.lesson33sql.service;

import by.tms.lesson33sql.entities.City;
import by.tms.lesson33sql.repositories.CityRepository;
import by.tms.lesson33sql.repositories.CityRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

@Slf4j
public class ServiceCityImpl {

    CityRepository cityRepository;

    public ServiceCityImpl(Path databasePropertiesFilePath) {
        this.cityRepository = new CityRepositoryImpl(databasePropertiesFilePath);
    }

    public boolean add(String nameCity) {
        if (nameCity == null || nameCity.isEmpty()) {
            log.info("Wrong name city");
            return false;
        }
        boolean isAdd = false;
        City city = new City(0, nameCity);
        int index = cityRepository.getID(city);
        if (index == 0) {
            isAdd = cityRepository.add(city);
            log.info("Add is {}", isAdd);
            return isAdd;
        }
        log.info("The city is already in the database");
        return false;
    }

    public Integer getIDCity(String nameCity) {
        if (nameCity == null || nameCity.isEmpty()) {
            log.info("Wrong name city");
            return 0;
        }
        return cityRepository.getID(new City(0, nameCity));
    }

    public boolean delete(Integer id) {
        if (id == null || id <= 0) {
            log.info("Wrong id");
            return false;
        }
        boolean isDelete = cityRepository.delete(id);
        log.info("Delete city {}", isDelete);

        return isDelete;
    }
}
