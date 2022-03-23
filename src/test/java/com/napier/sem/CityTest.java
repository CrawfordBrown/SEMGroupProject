package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class CityTest {

    City myCity = new City(
            3068,
            "Berlin",
            "DEU",
            "Berliini",
            3386667);

    @Test
    void canGetCityID() {
        assertEquals(3068, myCity.getId());
    }

    @Test
    void canSetCityID() {
        myCity.setID(3069);
        assertEquals(3069, myCity.getId());
    }

    @Test
    void canGetCityName(){
        assertEquals("Berlin", myCity.getName());
    }

    @Test
    void canSetCityName(){
        myCity.setName("BerlinB");
        assertEquals("BerlinB",myCity.getName());
    }

    @Test
    void canGetCountryCode(){
        assertEquals("DEU", myCity.getCountryCode());
    }

    @Test
    void canSetCountryCode(){
        myCity.setCountryCode("DEUD");
        assertEquals("DEUD", myCity.getCountryCode());
    }

    @Test
    void canGetDistrict(){
        assertEquals("Berliini", myCity.getDistrict());
    }

    @Test
    void canSetDistrict(){
        myCity.setDistrict("BerliiniB");
        assertEquals("BerliiniB", myCity.getDistrict());
    }

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
