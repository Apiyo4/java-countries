package com.lambdaschool.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController {
//   localhost:2020/age/age/{age} - return the countries that have a median age equal to or greater than the given age
    @GetMapping(value="/age/{age}", produces = "application/json")
    public ResponseEntity<?> getCountryWithMedianAgeAsAge(@PathVariable int age){
        ArrayList<Country> rtnCountry  = DemoApplication.ourCountryList.findCountries(c->c.getMedianAge() >= age);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);

    }

}
