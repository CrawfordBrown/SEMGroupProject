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
    void printCountries() {
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

   

}