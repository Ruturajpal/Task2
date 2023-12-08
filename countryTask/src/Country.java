package com.countryInforamtion.entity;




import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String countryname;
	private String capital;
	
	transient private List<CurrencyExchange> currencyExchanges;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public List<CurrencyExchange> getCurrencyExchanges() {
		return currencyExchanges;
	}

	public void setCurrencyExchanges(List<CurrencyExchange> currencyExchanges) {
		this.currencyExchanges = currencyExchanges;
	}

	public Country(int id, String countryname, String capital, List<CurrencyExchange> currencyExchanges) {
		super();
		this.id = id;
		this.countryname = countryname;
		this.capital = capital;
		this.currencyExchanges = currencyExchanges;
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryname=" + countryname + ", capital=" + capital + ", currencyExchanges="
				+ currencyExchanges + "]";
	}

	

}
