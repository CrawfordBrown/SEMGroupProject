package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
    }
/*
    @Test
    void testCountriesLargestToSmallest() {
        app.countriesInWorldLargestToSmallest();
    }

    @Test
    void testCountriesInContinentLargestToSmallest() {
        app.countriesInContinentLargestToSmallest("'Asia'");
    }
    */
}