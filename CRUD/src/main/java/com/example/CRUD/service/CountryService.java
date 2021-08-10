package com.example.CRUD.service;

import com.example.CRUD.exception.CountryNotFoundException;
import com.example.CRUD.model.Countries;
import com.example.CRUD.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;


    public List<Countries> findAllCountries(){
        return countryRepository.findAll();
    }

    public void deleteCountry (int id){
        countryRepository.deleteById(id);
    }

    public Countries findCountryById( int id){
        return countryRepository
                .findById(id).orElseThrow(() -> new CountryNotFoundException("country not found"));
    }
}
