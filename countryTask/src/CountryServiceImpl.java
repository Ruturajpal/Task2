package com.countryInforamtion.service;

import java.util.List;
import java.util.Optional;

import com.countryInforamtion.entity.Country;
import com.countryInforamtion.entity.CurrencyExchange;

public interface CountryServiceImpl {

	List<Country> getAllCountries();

    Country getCountryById(int id);

    Country createCountry(Country country);

    Country updateCountry(Country country);

    void deleteCountryById(int id);

    

	Country getCountry(int id);
}

