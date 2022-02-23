package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.City;

public interface CityService {

	public City getCity(String cityName);

	public List<City> getAllCities();

	public City addCity(City cityData);

	public City updateCity(String cityName, City cityData);

	public String deleteCity(String cityName);
}
