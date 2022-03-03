package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.City;
import com.digiplan.repositories.CityRepository;
import com.digiplan.services.CityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public City getCity(String cityName) {
		log.info("@Start getCity");
		City city = null;
		try {
			Optional<City> check = cityRepository.findById(cityName);
			if (check.isPresent())
				city = cityRepository.getById(cityName);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return city;
	}

	@Override
	public List<City> getAllCities() {
		log.info("@Start getAllCities");
		List<City> citiesList = null;
		try {
			citiesList = cityRepository.findAll();
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return citiesList;
	}

	@Override
	public City addCity(City cityData) {
		log.info("@Start addCity");
		City city = null;
		try {
			city = cityRepository.saveAndFlush(cityData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return city;
	}

	@Override
	public City updateCity(String cityName, City cityData) {
		log.info("@Start updateCity");
		City city = null;
		try {
			Optional<City> check = cityRepository.findById(cityName);
			if (check.isPresent())
				city = cityRepository.saveAndFlush(cityData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return city;
	}

	@Override
	public String deleteCity(String cityName) {
		log.info("@Start deleteCity");
		String status = "";
		try {
			cityRepository.deleteById(cityName);
			status = "Deleted";
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return status;
	}

}
