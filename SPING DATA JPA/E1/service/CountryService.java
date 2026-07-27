package com.cognizant.ormlearn.service;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.exception.CountryNotFoundException;
@Service
public class CountryService{
private final CountryRepository repo;
public CountryService(CountryRepository r){repo=r;}
@Transactional public List<Country> getAllCountries(){return repo.findAll();}
@Transactional public Country findCountryByCode(String c)throws CountryNotFoundException{return repo.findById(c).orElseThrow(CountryNotFoundException::new);}
@Transactional public void addCountry(Country c){repo.save(c);}
@Transactional public void updateCountry(String c,String n)throws CountryNotFoundException{Country x=findCountryByCode(c);x.setName(n);repo.save(x);}
@Transactional public void deleteCountry(String c){repo.deleteById(c);}
@Transactional public List<Country> searchCountries(String n){return repo.findByNameContainingIgnoreCase(n);}
}