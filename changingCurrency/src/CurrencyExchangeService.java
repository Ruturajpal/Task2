package com.currencycountry.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currencycountry.entity.CurrencyExchange;
import com.currencycountry.repository.CurrencyExchangeRepository;


import java.util.List;
import java.util.Optional;

@Service
public class CurrencyExchangeService implements CurrencyExchangeServiceImpl{

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    // Method to create a new currency exchange
    public CurrencyExchange createCurrencyExchange(CurrencyExchange currencyExchange) {
        return currencyExchangeRepository.save(currencyExchange);
    }

    // Method to retrieve all currency exchanges
    public List<CurrencyExchange> getAllCurrencyExchanges() {
        return currencyExchangeRepository.findAll();
    }

    // Method to retrieve a currency exchange by its ID
    public Optional<CurrencyExchange> getCurrencyExchangeById(int id) {
        return currencyExchangeRepository.findById(id);
    }

    // Method to update a currency exchange
    public CurrencyExchange updateCurrencyExchange(CurrencyExchange currencyExchange) {
        return currencyExchangeRepository.save(currencyExchange);
    }

    // Method to delete a currency exchange by its ID
    public void deleteCurrencyExchangeById(int id) {
        currencyExchangeRepository.deleteById(id);
    }

	@Override
	public List<CurrencyExchange> getCountryofCurrency(int countryid) {
		
		return currencyExchangeRepository.findByCountryid(countryid);
	}


    }



