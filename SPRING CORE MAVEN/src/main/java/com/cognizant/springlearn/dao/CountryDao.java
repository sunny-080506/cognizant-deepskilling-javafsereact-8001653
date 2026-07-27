package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Country;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountryDao {
    private List<Country> countryList;

    @PostConstruct
    private void loadCountries() {
        countryList = new ArrayList<>();
    }

    public List<Country> getAllCountries() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
