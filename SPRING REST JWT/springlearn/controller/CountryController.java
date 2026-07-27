package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private CountryService countryService;
	
	// GET - Get country India
	@GetMapping
	public Country getCountryIndia() {
		LOGGER.info("START - getCountryIndia()");
		Country country = countryService.getCountry("IN");
		LOGGER.info("END - getCountryIndia()");
		return country;
	}
	
	// GET - Get all countries
	@GetMapping("/all")
	public List<Country> getAllCountries() {
		LOGGER.info("START - getAllCountries()");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.info("END - getAllCountries() - Size: {}", countries.size());
		return countries;
	}
	
	// GET - Get country by code
	@GetMapping("/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START - getCountry() - code: {}", code);
		Country country = countryService.getCountry(code);
		LOGGER.info("END - getCountry()");
		return country;
	}
	
	// POST - Add country
	@PostMapping
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("START - addCountry() - country: {}", country);
		countryService.addCountry(country);
		LOGGER.info("END - addCountry()");
		return country;
	}
	
	// PUT - Update country
	@PutMapping
	public Country updateCountry(@RequestBody @Valid Country country) throws CountryNotFoundException {
		LOGGER.info("START - updateCountry() - country: {}", country);
		Country updatedCountry = countryService.updateCountry(country);
		LOGGER.info("END - updateCountry()");
		return updatedCountry;
	}
	
	// DELETE - Delete country
	@DeleteMapping("/{code}")
	public void deleteCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START - deleteCountry() - code: {}", code);
		countryService.deleteCountry(code);
		LOGGER.info("END - deleteCountry()");
	}
}
