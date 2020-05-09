package com.lambdaschool.demo;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong counter =  new AtomicLong();
    private long id;
    private String name;
    private int population;
    private int landMassKm2;
    private int medianAge;

    public Country(String name, int population, int landMassKm2, int medianAge) {
        this.id =  counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMassKm2 = landMassKm2;
        this.medianAge = medianAge;
    }
}
