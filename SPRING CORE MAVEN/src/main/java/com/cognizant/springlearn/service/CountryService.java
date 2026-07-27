package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public Country getCountry(String code) throws CountryNotFoundException {
        List<Country> countries = countryDao.getAllCountries();
        for (Country c : countries) {
            if (c.getCode().equalsIgnoreCase(code))
                return c;
        }
        throw new CountryNotFoundException();
    }

    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }
}
