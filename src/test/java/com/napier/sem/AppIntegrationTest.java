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
        Country country = app.getCountry("Spain").get(5);
        assertEquals(country.getPopulation(), 1013662000);
    }

    @Test
    void testGetCity() {
        City city = app.getCities("Bombay").get(5);
        assertEquals(city.getPopulation(), 1013662000);

    }
    /*
    @Test
    void testGetEmployee()
    {
        Employee emp = app.getEmployee(255530);
        assertEquals(emp.emp_no, 255530);
        assertEquals(emp.first_name, "Ronghao");
        assertEquals(emp.last_name, "Garigliano");
    }
     */
}