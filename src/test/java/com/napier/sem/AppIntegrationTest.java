package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    static App app;

    // Testing connection to database
    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    // Testing Country Class
    @Test
    void testGetCountry() {
        Country country = app.getCountry("United Arab Emirates");
        assertEquals(country.getCode(),"ARE");
        assertEquals(country.getContinent(),"Asia");
        assertEquals(country.getRegion(),"Middle East");
        assertEquals(country.getSurfaceArea(),83600);
        assertEquals(country.getIndepYear(),1971);
        assertEquals(country.getPopulation(),2441000);
        assertEquals(country.getLifeExpectancy(), 74.0);
        assertEquals(country.getGnp(),37966);
        assertEquals(country.getGnpOld(),36846);
        assertEquals(country.getLocalName(),"Al-Imarat al-´Arabiya al-Muttahida");
        assertEquals(country.getGovernmentForm(),"Emirate Federation");
        assertEquals(country.getHeadOfState(),"Zayid bin Sultan al-Nahayan");
        assertEquals(country.getCapital(),65);
        assertEquals(country.getCode2(),"AE");
    }


    @Test
    void testGetAllCountries(){
        List<Country> countries = app.getCountries();
        assertEquals(countries.size(), 239);
    }

    @Test
    void testGetCountryInContinent(){
        Country country = app.countriesInContinentLargestToSmallest("'Asia'").get(1);
        assertEquals(country.getName(), "India");
    }


    // Testing City Class
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

    @AfterAll
    static void close() {
        app.disconnect();
    }




}