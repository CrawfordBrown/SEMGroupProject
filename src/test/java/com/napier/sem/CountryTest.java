package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class CountryTest {

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
    void canGetCountryCode() {
        assertEquals("DEU", myCountry.getCode()
);
    }

    @Test
    void canSetCountryCode() {
       myCountry.setCode("GER");
       assertEquals("GER", myCountry.getCode());
    }

    @Test
    void canGetCountryName() {
        assertEquals("Germany", myCountry.getName()
);
    }

    @Test
    void canSetCountryGermany() {
       myCountry.setName("Scotland");
       assertEquals("Scotland", myCountry.getName());
    }
}
