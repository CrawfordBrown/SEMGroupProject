package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }


    @Test
    void printCountriesTestNull()
    {
        app.printCountries(null);
    }



    @Test
    void testPrintCountriesEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        app.printCountries(countries);
    }

    @Test
    void testPrintCountriesContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printCountries(countries);
    }

    @Test
    void testPrintCountries() {
        ArrayList<Country> countries = new ArrayList<>();

        Country myCountry = new Country(
                "DEU",
                "Germany",
                "Europe",
                "Western Europe",
                357022,
                1955,
                82164700,
                77,
                2133367,
                2102826,
                "Deutschland",
                "Federal Republic",
                "Johannes Rau",
                3068,
                "DE");

        countries.add(myCountry);
        app.printCountries(countries);

    }

    @Test
    void printCitiesNull(){
        app.printCities(null);
    }

    @Test
    void printCitiesNullMember() {
        ArrayList<City> cityHasNull = new ArrayList<>();
        cityHasNull.add(null);
    }

    @Test
    void printCitiesEmpty(){
        ArrayList<City> emptyCity = new ArrayList<>();
        app.printCities(emptyCity);
    }

    @Test
    void printCitiesWithValues(){
        ArrayList<City> cities = new ArrayList<>();

        City myCity = new City(
                3068,
                "Berlin",
                "DEU",
                "Berliini",
                3386667);

        cities.add(myCity);
        app.printCities(cities);
    }


}