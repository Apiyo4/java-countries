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
//     localhost:2020/age/min - return the country with the smallest median age
    @GetMapping(value="/min", produces = "application/json")
    public ResponseEntity<?> getCountryWithSmallestMedian(){
        DemoApplication.ourCountryList.countryList.sort((c1,c2)->c1.getMedianAge() - c2.getMedianAge());
        Country smallestMedianCountry = DemoApplication.ourCountryList.countryList.get(0);
        return new ResponseEntity<>(smallestMedianCountry, HttpStatus.OK);
    }
//    localhost:2020/age/max - return the country the the greatest median age
    @GetMapping(value = "/max", produces = "application/json")
    public ResponseEntity<?> getCountryWithLargestMedian(){
        DemoApplication.ourCountryList.countryList.sort((c1,c2)->c2.getMedianAge()-c1.getMedianAge());
        Country largestMedianCountry =  DemoApplication.ourCountryList.countryList.get(0);
        return new ResponseEntity<>(largestMedianCountry, HttpStatus.OK);
    }


}
