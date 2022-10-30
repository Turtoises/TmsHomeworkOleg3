package by.tms.lesson33sql.service;

import by.tms.lesson33sql.entities.City;
import by.tms.lesson33sql.repositories.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class ServiceCityImpl {

    private static Logger logger = LoggerFactory.getLogger("ServiceCityImpl");

    CityRepository cityRepository;

    public ServiceCityImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public boolean add(String nameCity) {
        if (nameCity == null || nameCity.isEmpty()) {
            logger.info("Wrong name city");
            return false;
        }
        boolean isAdd = false;
        City city = new City(0, nameCity);
        int index = cityRepository.getID(city);
        if (index == 0) {
            isAdd = cityRepository.add(city);
            logger.info("Add is {}", isAdd);
            return isAdd;
        }
        logger.info("The city is already in the database");
        return false;
    }

    public Integer getIDCity(String nameCity) {
        if (nameCity == null || nameCity.isEmpty()) {
            logger.info("Wrong name city");
            return 0;
        }
        return cityRepository.getID(new City(0, nameCity));
    }

    public boolean delete(Integer id) {
        if (id == null || id <= 0) {
            logger.info("Wrong id");
            return false;
        }
        boolean isDelete = cityRepository.delete(id);
        logger.info("Delete city {}", isDelete);

        return isDelete;
    }
}
