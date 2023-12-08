package com.currencycountry.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.currencycountry.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {

    List<CurrencyExchange> findByCountryid(Integer countryid);
}
