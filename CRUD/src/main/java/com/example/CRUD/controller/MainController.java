package com.example.CRUD.controller;

import com.example.CRUD.model.Countries;
import com.example.CRUD.repository.CountryRepository;
import com.example.CRUD.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v2")
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryService countryService;

    @GetMapping("/")
    public String home(){
        return "<h1> hello </h1>";
    }

    //get all the countries
    @GetMapping(value = "/all")
    public ResponseEntity<List<Countries>> getAllCountries(){
        List<Countries> countries = countryService.findAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    //find by id
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Countries> getCountry(@PathVariable("id") int id){
        Countries country = countryService.findCountryById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    //add country
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Countries> addCountry(@RequestBody Countries countries) throws ClassNotFoundException {
        if( countries == null){
            throw new ClassNotFoundException("Missing data exception");
        }else {
            System.out.println(countries.getCountry_name());
            Countries newCountry = countryRepository.save(countries);
            return  new ResponseEntity<>(newCountry, HttpStatus.CREATED);
        }
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Countries> updateCountry( @RequestBody Countries countries) throws ClassNotFoundException {
        if( countries == null){
            throw new ClassNotFoundException("Missing data exception");
        }else {
            Countries newCountry = countryRepository.save(countries);
            return  new ResponseEntity<>(newCountry, HttpStatus.CREATED);
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Countries> deleteCountry(@PathVariable("id") int id){
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
