package com.countryInforamtion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.countryInforamtion.entity.Country;
import com.countryInforamtion.service.CountryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country createdCountry = countryService.createCountry(country);
        return new ResponseEntity<>(createdCountry, HttpStatus.CREATED);
    }

   
    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

 
    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable int id) {
        Country country = countryService.getCountryById(id);
        
        return country;
    }
   
    }

  


