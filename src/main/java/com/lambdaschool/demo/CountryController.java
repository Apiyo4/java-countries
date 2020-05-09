package com.lambdaschool.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController {
    //localhost:2020/names/all
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAllCountries(){
        DemoApplication.ourCountryList.countryList.sort((c1,c2)->c1.getName().compareToIgnoreCase(c2.getName()));
        return  new ResponseEntity<>(DemoApplication.ourCountryList.countryList, HttpStatus.OK);
    }
//  localhost:2020/names/start/{letter}
    @GetMapping(value="start/{letter}", produces = "application/json")
    public ResponseEntity<?> getCountyByLetter(@PathVariable char letter){
        ArrayList<Country> rtnCountry =
                DemoApplication.ourCountryList.findCountries(e->e.getName().toUpperCase().charAt(0)==Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
//   localhost:2020/names/size/{number} - return the countries alphabetically that have a name equal to or longer than
//   the given length
    @GetMapping(value="/size/{number}", produces = "application/json")
    public ResponseEntity<?> getCountriesLargeAndEqualToNumber(@PathVariable int number){
        ArrayList<Country> rtnCountry =  DemoApplication.ourCountryList.findCountries(c->c.getLandMassKm2() >= number);
        rtnCountry.sort((c1,c2)->c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>( rtnCountry, HttpStatus.OK);
    }



}
