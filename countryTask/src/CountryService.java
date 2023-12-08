package com.countryInforamtion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.countryInforamtion.entity.Country;
import com.countryInforamtion.entity.CurrencyExchange;
import com.countryInforamtion.repository.CountryRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

	@Service
	public class CountryService implements CountryServiceImpl{

	    @Autowired
	    private CountryRepository countryRepository;
	    
	    @Autowired
	    private CountryClient countryClient;
	    
	    

	    public CountryService(CountryRepository countryRepository, CountryClient countryClient) {
			super();
			this.countryRepository = countryRepository;
			this.countryClient = countryClient;
		}

		// Method to create a new country
	    public Country createCountry(Country country) {
	        return countryRepository.save(country);
	    }
	    
	   

	    // Method to update a country
	    public Country updateCountry(Country country) {
	        return countryRepository.save(country);
	    }

	    // Method to delete a country by its ID
	    public void deleteCountryById(int id) {
	        countryRepository.deleteById(id);
	    }
	    @Override
	    public List<Country> getAllCountries() {
	        List<Country> countries = countryRepository.findAll();

	        List<Country> newCountryList = countries.stream().map(country -> {
	            country.setCurrencyExchanges(countryClient.getCountryOfCurrency(country.getId()));
	            return country;
	        }).collect(Collectors.toList());

	        return newCountryList;
	    }



//		@Override
//		public Country getCountryOfCurrency(int id) {
//		    Country country = countryRepository.findById(id)
//		            .orElseThrow(() -> new RuntimeException("Country not found"));
//		    
//		    country.setCurrencyExchanges(countryClient.getCountryOfCurrency(country.getId()));
//		    return country;
//		}

	    @Override
	    public Country getCountry(int id) {
	        Optional<Country> countryOptional = countryRepository.findById(id);
	        return countryOptional.orElse(null);
	    }


		@Override
		public Country getCountryById(int id) {
			// TODO Auto-generated method stub
			return countryRepository.getById(id);
		}

		


	}


