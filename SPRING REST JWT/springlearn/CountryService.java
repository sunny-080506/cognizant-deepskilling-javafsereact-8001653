package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	
	@Autowired
	private CountryDao countryDao;
	
	@Transactional
	public Country getCountry(String code) throws CountryNotFoundException {
		LOGGER.info("START - getCountry() - code: {}", code);
		
		List<Country> countries = countryDao.getAllCountries();
		LOGGER.debug("Countries: {}", countries);
		
		for (Country country : countries) {
			if (country.getCode().equalsIgnoreCase(code)) {
				LOGGER.info("END - getCountry() - Found: {}", country);
				return country;
			}
		}
		
		LOGGER.error("Country not found with code: {}", code);
		throw new CountryNotFoundException("Country not found with code: " + code);
	}
	
	@Transactional
	public List<Country> getAllCountries() {
		LOGGER.info("START - getAllCountries()");
		List<Country> countries = countryDao.getAllCountries();
		LOGGER.info("END - getAllCountries() - Size: {}", countries.size());
		return countries;
	}
	
	@Transactional
	public Country addCountry(Country country) {
		LOGGER.info("START - addCountry() - country: {}", country);
		Country savedCountry = countryDao.addCountry(country);
		LOGGER.info("END - addCountry()");
		return savedCountry;
	}
	
	@Transactional
	public Country updateCountry(Country country) throws CountryNotFoundException {
		LOGGER.info("START - updateCountry() - country: {}", country);
		Country updatedCountry = countryDao.updateCountry(country);
		LOGGER.info("END - updateCountry()");
		return updatedCountry;
	}
	
	@Transactional
	public void deleteCountry(String code) throws CountryNotFoundException {
		LOGGER.info("START - deleteCountry() - code: {}", code);
		countryDao.deleteCountry(code);
		LOGGER.info("END - deleteCountry()");
	}
}
