package com.currencycountry.controller;

import org.springframework.web.bind.annotation.RestController;

import com.currencycountry.entity.CurrencyExchange;
import com.currencycountry.service.CurrencyExchangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/currencyExchanges")
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    // Endpoint to create a new currency exchange
    @PostMapping
    public ResponseEntity<CurrencyExchange> createCurrencyExchange(@RequestBody CurrencyExchange currencyExchange) {
        CurrencyExchange createdCurrencyExchange = currencyExchangeService.createCurrencyExchange(currencyExchange);
        return new ResponseEntity<>(createdCurrencyExchange, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all currency exchanges
    @GetMapping
    public ResponseEntity<List<CurrencyExchange>> getAllCurrencyExchanges() {
        List<CurrencyExchange> currencyExchanges = currencyExchangeService.getAllCurrencyExchanges();
        return new ResponseEntity<>(currencyExchanges, HttpStatus.OK);
    }

    // Endpoint to retrieve a currency exchange by its ID
    @GetMapping("/{id}")
    public ResponseEntity<CurrencyExchange> getCurrencyExchangeById(@PathVariable int id) {
        Optional<CurrencyExchange> currencyExchange = currencyExchangeService.getCurrencyExchangeById(id);
        return currencyExchange.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to update a currency exchange
    @PutMapping("/{id}")
    public ResponseEntity<CurrencyExchange> updateCurrencyExchange(@PathVariable int id, @RequestBody CurrencyExchange currencyExchange) {
        Optional<CurrencyExchange> existingCurrencyExchangeOptional = currencyExchangeService.getCurrencyExchangeById(id);
        if (existingCurrencyExchangeOptional.isPresent()) {
            CurrencyExchange existingCurrencyExchange = existingCurrencyExchangeOptional.get();
            

            // You might need to update other fields as well based on your requirements

            CurrencyExchange updatedCurrencyExchange = currencyExchangeService.updateCurrencyExchange(existingCurrencyExchange);
            return new ResponseEntity<>(updatedCurrencyExchange, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a currency exchange by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrencyExchange(@PathVariable int id) {
        Optional<CurrencyExchange> currencyExchange = currencyExchangeService.getCurrencyExchangeById(id);
        if (currencyExchange.isPresent()) {
            currencyExchangeService.deleteCurrencyExchangeById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }}
        @GetMapping("/country/{countryid}")
        public ResponseEntity<List<CurrencyExchange>> getCountryofCurrency(@PathVariable int countryid) {
            List<CurrencyExchange> currencyExchanges = currencyExchangeService.getCountryofCurrency(countryid);
            return new ResponseEntity<>(currencyExchanges, HttpStatus.OK);
        }
    
    
    }
