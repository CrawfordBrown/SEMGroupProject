package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }
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
    @Test
    void testCountriesLargestToSmallestEmpty()
    {
         app.countriesInWorldLargestToSmallest();
    }

    @Test
    void testCountriesInContinentLargestToSmallest()
    {
        app.countriesInContinentLargestToSmallest(null);
    }

    @Test
    void testCountriesInRegionLargestToSmallest()
    {
        app.countriesInRegionLargestToSmallest(null);
    }

    @Test
    void testTopPopulatedCountriesInWorld()
    {
        app.TopPopulatedCountriesInWorld(1);
    }

    @Test
    void testTopPopulatedCountriesInContinent()
    {
        app.TopPopulatedCountriesInContinent(1, "'Asia'");
    }
    @Test
    void testTopPopulatedCountriesInRegion()
    {
        app.TopPopulatedCountriesInRegion(1, "'South East Asia'");
    }

}