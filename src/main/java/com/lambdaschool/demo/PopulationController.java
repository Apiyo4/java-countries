package com.lambdaschool.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController {
//    localhost:2020/population/size/{people} - return the countries that have a population equal to or greater than
//    return the countries that have a population equal to or greater than the given population
//    the
//    given population
    @GetMapping(value="/size/{people}", produces = "application/json")
    public ResponseEntity<?> getCountriesWithPopulationGreaterThanOrEqualTo(@PathVariable int people){
        ArrayList<Country> rtnCountry = DemoApplication.ourCountryList.findCountries(c->c.getPopulation()>= people);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
//     localhost:2020/population/min - return the country with the smallest population
    @GetMapping(value="/min", produces = "application/json")
    public ResponseEntity<?> getCountryWithLowestPopulation(){
        DemoApplication.ourCountryList.countryList.sort((c1,c2)->c1.getPopulation() - c2.getPopulation());
        Country newCountry = DemoApplication.ourCountryList.countryList.get(0);
        return new ResponseEntity<>(newCountry, HttpStatus.OK);

    }
}

