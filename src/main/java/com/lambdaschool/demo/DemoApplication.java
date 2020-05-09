package com.lambdaschool.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {
    static CountryList ourCountryList;
    public static void main(String[] args) {
        ourCountryList = new CountryList();
        SpringApplication.run(DemoApplication.class, args);

    }


}
