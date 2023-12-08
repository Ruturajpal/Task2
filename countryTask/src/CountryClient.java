package com.countryInforamtion.service;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.countryInforamtion.entity.CurrencyExchange;

@FeignClient(url = "http://localhost:8082",value = "CurrencyExchange-Client")
public interface CountryClient {

    @GetMapping("/currencyexchange/country/{countryid}")
    List<CurrencyExchange> getCountryOfCurrency(@PathVariable Integer countryid);
}
