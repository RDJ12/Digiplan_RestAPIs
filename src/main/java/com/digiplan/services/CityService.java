package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.City;

public interface CityService {

    City getCity(String cityName);

    List<City> getAllCities();

    City addCity(City cityData);

    City updateCity(String cityName, City cityData);

    String deleteCity(String cityName);
}
