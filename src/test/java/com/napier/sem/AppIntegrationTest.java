package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    static App app;

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
        City city = app.getCities().get(0);
        assertEquals(city.getName(), "Kabul");

    }

}