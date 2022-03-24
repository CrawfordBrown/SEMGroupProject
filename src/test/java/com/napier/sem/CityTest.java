package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit testing of City class
 */

public class CityTest {

    City myCity = new City(
            3068,
            "Berlin",
            "DEU",
            "Berliini",
            3386667);

    //Testing the getter and setter of the ID parameter
    @Test
    void canGetCityID() {
        assertEquals(3068, myCity.getId());
    }

    @Test
    void canSetCityID() {
        myCity.setID(3069);
        assertEquals(3069, myCity.getId());
    }

    //Testing the getter and setter of the Name parameter
    @Test
    void canGetCityName(){
        assertEquals("Berlin", myCity.getName());
    }

    @Test
    void canSetCityName(){
        myCity.setName("BerlinB");
        assertEquals("BerlinB",myCity.getName());
    }

    //Testing the getter and setter of Country Code parameter
    @Test
    void canGetCountryCode(){
        assertEquals("DEU", myCity.getCountryCode());
    }

    @Test
    void canSetCountryCode(){
        myCity.setCountryCode("DEUD");
        assertEquals("DEUD", myCity.getCountryCode());
    }

    //Testing the getter and setter of District parameter
    @Test
    void canGetDistrict(){
        assertEquals("Berliini", myCity.getDistrict());
    }

    @Test
    void canSetDistrict(){
        myCity.setDistrict("BerliiniB");
        assertEquals("BerliiniB", myCity.getDistrict());
    }

    //Testing the getter and setter of the Population parameter
    @Test
    void canGetPopulation(){
        assertEquals(3386667, myCity.getPopulation());
    }

    @Test
    void canSetPopulation(){
        myCity.setPopulation(3386969);
        assertEquals(3386969, myCity.getPopulation());
    }
}
