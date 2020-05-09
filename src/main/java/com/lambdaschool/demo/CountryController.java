package com.lambdaschool.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/name")
public class CountryController {
    //localhost:2020/name/all
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAllCountries(){
        DemoApplication.ourCountryList.countryList.sort((c1,c2)->c1.getName().compareToIgnoreCase(c2.getName()));
        return  new ResponseEntity<>(DemoApplication.ourCountryList.countryList, HttpStatus.OK);
    }
}
