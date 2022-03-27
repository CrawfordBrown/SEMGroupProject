package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    static App app;

    // Checks if the database connects
    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 30000);

    }


    @Test
    void testGetCountry() {
        Country country = app.getCountry().get(1);
        assertEquals(country.getPopulation(), 22720000);
    }

    @Test
    void testGetCity() {
        City city = app.getCity("London");
        assertEquals(city.getCountryCode(), "GBR");
        assertEquals(city.getPopulation(), 7285000);
        assertEquals(city.getDistrict(),"England");

    }

    @Test
    void testGetALLCities(){
        List<City> cities = app.getCities();
        assertEquals(cities.size(), 4079);
    }

}