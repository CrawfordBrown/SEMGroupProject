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
    void canSetCountryName() {
       myCountry.setName("Scotland");
       assertEquals("Scotland", myCountry.getName());
    }

    @Test
    void canGetCountryContinent() {
        assertEquals("Europe", myCountry.getContinent()
);
    }

    @Test
    void canSetCountryContinent() {
       myCountry.setContinent("Asia");
       assertEquals("Asia", myCountry.getContinent());
    }

    @Test
    void canGetCountryRegion() {
        assertEquals("Western Europe", myCountry.getRegion()
);
    }

    @Test
    void canSetCountryRegion() {
       myCountry.setRegion("South East Asia");
       assertEquals("South East Asia", myCountry.getRegion());
    }


    @Test
    void canGetCountrySurfaceArea() {
        assertEquals(357022, myCountry.getSurfaceArea()
);
    }

    @Test
    void canSetCountrySurfaceArea() {
       myCountry.setSurfaceArea(500000);
       assertEquals(500000, myCountry.getSurfaceArea());
    }

    @Test
    void canGetCountryIndepYear() {
        assertEquals(1955, myCountry.getIndepYear()
);
    }

    @Test
    void canSetCountryIndepYear() {
       myCountry.setIndepYear(1980);
       assertEquals(1980, myCountry.getIndepYear());
    }

    @Test
    void canGetCountryPopulation() {
        assertEquals(82164700, myCountry.getPopulation()
);
    }

    @Test
    void canSetCountryPopulation() {
       myCountry.setPopulation(821647222);
       assertEquals(821647222, myCountry.getPopulation());
    }

    @Test
    void canGetCountryLifeExpectancy() {
        assertEquals(77, myCountry.getLifeExpectancy()
);
    }

    @Test
    void canSetCountryLifeExpectancy() {
       myCountry.setLifeExpectancy(90);
       assertEquals(90, myCountry.getLifeExpectancy());
    }

    @Test
    void canGetCountryGNP() {
        assertEquals(2133367, myCountry.getGnp()
);
    }

    @Test
    void canSetCountryGNP() {
       myCountry.setGnp(55555);
       assertEquals(55555, myCountry.getGnp());
    }

    @Test
    void canGetCountryOldGNP() {
        assertEquals(2102826, myCountry.getGnpOld()
);
    }

    @Test
    void canSetCountryOldGNP() {
       myCountry.setGnpOld(55555);
       assertEquals(55555, myCountry.getGnpOld());
    }
//  String headOfState, Integer capital, String code2

    @Test
    void canGetCountryLocalName() {
        assertEquals("Deutschland", myCountry.getLocalName()
        );
    }

    @Test
    void canSetCountryLocalName() {
        myCountry.setLocalName("Germanic");
        assertEquals("Germanic", myCountry.getLocalName());
    }

    @Test
    void canGetCountryGovermentForm() {
        assertEquals("Federal Republic", myCountry.getGovernmentForm()
        );
    }

    @Test
    void canSetCountryGovermentForm() {
        myCountry.setGovernmentForm("Monarchy");
        assertEquals("Monarchy", myCountry.getGovernmentForm());
    }

    @Test
    void canGetCountryHeadOfState() {
        assertEquals("Johannes Rau", myCountry.getHeadOfState()
        );
    }

    @Test
    void canSetCountryHeadOfState() {
        myCountry.setHeadOfState("Boris J");
        assertEquals("Boris J", myCountry.getHeadOfState());
    }

    @Test
    void canGetCountryCapital() {
        assertEquals(3068, myCountry.getCapital()
        );
    }

    @Test
    void canSetCountryCapital() {
        myCountry.setCapital(3025);
        assertEquals(3025, myCountry.getCapital());
    }

    @Test
    void canGetCountryCode2() {
        assertEquals("DE", myCountry.getCode2()
        );
    }

    @Test
    void canSetCountryCode2() {
        myCountry.setCode2("GE");
        assertEquals("GE", myCountry.getCode2());
    }

}
