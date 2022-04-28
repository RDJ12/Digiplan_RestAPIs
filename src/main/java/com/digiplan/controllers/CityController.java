package com.digiplan.controllers;

import com.digiplan.entities.City;
import com.digiplan.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/getCity/{cityName}")
    public ResponseEntity<City> getCity(@PathVariable String cityName) {
        City city = this.cityService.getCity(cityName);
        if (city != null)
            return new ResponseEntity<City>(city, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/fetchcities")
    public List<City> getAllCities() {
        return this.cityService.getAllCities();
    }

    @PostMapping("/addCity")
    public ResponseEntity<City> addCity(@RequestBody City cityData) {
        return new ResponseEntity<City>(this.cityService.addCity(cityData), HttpStatus.CREATED);
    }

    @PutMapping("/ ")
    public ResponseEntity<City> updateCity(@PathVariable String cityName, @RequestBody City cityData) {
        City city = this.cityService.updateCity(cityName, cityData);
        if (city != null)
            return new ResponseEntity<City>(city, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteCity/{cityName}")
    public ResponseEntity<String> deleteCity(@PathVariable String cityName) {
        String status = this.cityService.deleteCity(cityName);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
