package by.tms.lesson33sql.repositories;

import by.tms.lesson33sql.entities.City;

public interface CityRepository extends Repository<City> {

    Integer getID(City city);
}
