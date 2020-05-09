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
//    the
//    given population
    @GetMapping(value="/size/{people}", produces = "application/json")
    public ResponseEntity<?> getCountriesWithPopulationGreaterThanOrEqualTo(@PathVariable int people){
        ArrayList<Country> rtnCountry = DemoApplication.ourCountryList.findCountries(c->c.getPopulation()>= people);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

}

