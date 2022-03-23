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
        Country country = app.getCountry("Arubu").get(0);
        assertEquals(country.getName(), "Aruba");
    }


    @Test
    void testGetCity() {
        City city = app.getCities("Bombay").get(0);
        assertEquals(city.getPopulation(), 1780000);

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