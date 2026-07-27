package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Repository
public class CountryDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryDao.class);
	
	private static List<Country> countries = new ArrayList<>();
	
	static {
		// Initialize with sample countries
		countries.add(new Country() {{
			setCode("US");
			setName("United States");
		}});
		countries.add(new Country() {{
			setCode("DE");
			setName("Germany");
		}});
		countries.add(new Country() {{
			setCode("IN");
			setName("India");
		}});
		countries.add(new Country() {{
			setCode("JP");
			setName("Japan");
		}});
	}
	
	public List<Country> getAllCountries() {
		LOGGER.info("START - getAllCountries()");
		LOGGER.info("END - getAllCountries() - Size: {}", countries.size());
		return countries;
	}
	
	public Country addCountry(Country country) {
		LOGGER.info("START - addCountry() - country: {}", country);
		countries.add(country);
		LOGGER.info("END - addCountry()");
		return country;
	}
	
	public Country updateCountry(Country country) throws CountryNotFoundException {
		LOGGER.info("START - updateCountry() - country: {}", country);
		
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getCode().equalsIgnoreCase(country.getCode())) {
				countries.set(i, country);
				LOGGER.info("END - updateCountry() - Updated");
				return country;
			}
		}
		
		LOGGER.error("Country not found for update: {}", country.getCode());
		throw new CountryNotFoundException("Country not found with code: " + country.getCode());
	}
	
	public void deleteCountry(String code) throws CountryNotFoundException {
		LOGGER.info("START - deleteCountry() - code: {}", code);
		
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getCode().equalsIgnoreCase(code)) {
				countries.remove(i);
				LOGGER.info("END - deleteCountry() - Deleted");
				return;
			}
		}
		
		LOGGER.error("Country not found for deletion: {}", code);
		throw new CountryNotFoundException("Country not found with code: " + code);
	}
}
