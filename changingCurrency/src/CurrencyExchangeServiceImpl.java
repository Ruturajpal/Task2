package com.currencycountry.service;
import java.util.List;
import java.util.Optional;

import com.currencycountry.entity.CurrencyExchange;
public interface CurrencyExchangeServiceImpl {
	

	

	    CurrencyExchange createCurrencyExchange(CurrencyExchange currencyExchange);

	    List<CurrencyExchange> getAllCurrencyExchanges();

	    Optional<CurrencyExchange> getCurrencyExchangeById(int id);

	    CurrencyExchange updateCurrencyExchange(CurrencyExchange currencyExchange);

	    void deleteCurrencyExchangeById(int id);

	    List<CurrencyExchange> getCountryofCurrency(int countryid);
	}


