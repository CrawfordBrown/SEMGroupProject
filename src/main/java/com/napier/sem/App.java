package com.napier.sem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " +                                  Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }


    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }


    /*
    All the countries in the world organised by largest population to smallest
     */

    public ArrayList<Country> countriesInWorldLargestToSmallest() {

        System.out.println("All the countries in the world organised by largest population to smallest");
        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql = "select * from country order by Population desc;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            // Return new country if valid.
            // Check one is returned

            ArrayList<Country> report1 = new ArrayList<Country>();

            while (rset.next()) {
                String code = rset.getString("code");
                String name = rset.getString("name");
                String continent = rset.getString("continent");
                String region = rset.getString("region");
                int surfaceArea = rset.getInt("surfaceArea");
                int indepYear = rset.getInt("indepYear");
                int population = rset.getInt("population");
                int lifeExpectancy = rset.getInt("lifeExpectancy");
                int gnp = rset.getInt("gnp");
                int gnpOld = rset.getInt("gnpOld");
                String localName = rset.getString("localName");
                String governmentForm = rset.getString("governmentForm");
                String headOfState = rset.getString("headOfState");
                int capital = rset.getInt("capital");
                String code2 = rset.getString("code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                sb.append(country.toString() + "\r\n");
                report1.add(country);
            }
            // Displays the records
               return report1;
//                for(int i = 0; i < report1.size(); i++) {
//                System.out.println(report1.get(i).toString());
//            }
//            return null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

     /*
    All the countries in a continent organised by largest population to smallest
     */

    public ArrayList<Country> countriesInContinentLargestToSmallest(String cont) {

        System.out.println("All the countries in a continent organised by largest population to smallest");
        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql2 = "select * " +
                    "from country " +
                    "where Continent = " + cont +
                    "Order By Population desc;";
            // Execute SQL statement
            ResultSet rset2 = stmt.executeQuery(sql2);
            // Return new country if valid.
            // Check one is returned

            ArrayList<Country> report2 = new ArrayList<Country>();

            while (rset2.next()) {
                String code = rset2.getString("code");
                String name = rset2.getString("name");
                String continent = rset2.getString("continent");
                String region = rset2.getString("region");
                int surfaceArea = rset2.getInt("surfaceArea");
                int indepYear = rset2.getInt("indepYear");
                int population = rset2.getInt("population");
                int lifeExpectancy = rset2.getInt("lifeExpectancy");
                int gnp = rset2.getInt("gnp");
                int gnpOld = rset2.getInt("gnpOld");
                String localName = rset2.getString("localName");
                String governmentForm = rset2.getString("governmentForm");
                String headOfState = rset2.getString("headOfState");
                int capital = rset2.getInt("capital");
                String code2 = rset2.getString("code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                sb.append(country.toString() + "\r\n");
                report2.add(country);
            }
            // Displays the records
                return report2;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }

    }


    //All the countries in a Region organised by largest population to smallest

    public ArrayList<Country> countriesInRegionLargestToSmallest(String reg) {

        System.out.println("All the countries in a Region organised by largest population to smallest");
        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql3 = "select * " +
                    "from country " +
                    "where Region = " + reg +
                    "Order By Population desc;";
            // Execute SQL statement
            ResultSet rset3 = stmt.executeQuery(sql3);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> report3 = new ArrayList<Country>();

            while (rset3.next()) {
                String code = rset3.getString("code");
                String name = rset3.getString("name");
                String continent = rset3.getString("continent");
                String region = rset3.getString("region");
                int surfaceArea = rset3.getInt("surfaceArea");
                int indepYear = rset3.getInt("indepYear");
                int population = rset3.getInt("population");
                int lifeExpectancy = rset3.getInt("lifeExpectancy");
                int gnp = rset3.getInt("gnp");
                int gnpOld = rset3.getInt("gnpOld");
                String localName = rset3.getString("localName");
                String governmentForm = rset3.getString("governmentForm");
                String headOfState = rset3.getString("headOfState");
                int capital = rset3.getInt("capital");
                String code2 = rset3.getString("code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                sb.append(country.toString() + "\r\n");
                report3.add(country);
            }
            // Displays the records
            return report3;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }

    }

    //Top n populated countries in world

    public ArrayList<Country> TopPopulatedCountriesInWorld(int num) {

        System.out.println("Top n populated countries in world");
        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql4 = "select * " +
                    "from country " +
                    "Order By Population desc Limit " + num + ";";
            // Execute SQL statement
            ResultSet rset4 = stmt.executeQuery(sql4);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> report4 = new ArrayList<Country>();

            while (rset4.next()) {
                String code = rset4.getString("code");
                String name = rset4.getString("name");
                String continent = rset4.getString("continent");
                String region = rset4.getString("region");
                int surfaceArea = rset4.getInt("surfaceArea");
                int indepYear = rset4.getInt("indepYear");
                int population = rset4.getInt("population");
                int lifeExpectancy = rset4.getInt("lifeExpectancy");
                int gnp = rset4.getInt("gnp");
                int gnpOld = rset4.getInt("gnpOld");
                String localName = rset4.getString("localName");
                String governmentForm = rset4.getString("governmentForm");
                String headOfState = rset4.getString("headOfState");
                int capital = rset4.getInt("capital");
                String code2 = rset4.getString("code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                sb.append(country.toString() + "\r\n");
                report4.add(country);
            }
            // Displays the records
            return report4;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }

    }

    //Top n populated countries in continent

    public ArrayList<Country> TopPopulatedCountriesInContinent(int num, String cont) {

        System.out.println("Top n populated countries in Continent");
        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql4 = "select * " +
                    "from country " +
                    "where Continent = " + cont +
                    "Order By Population desc Limit " + num + ";";
            // Execute SQL statement
            ResultSet rset4 = stmt.executeQuery(sql4);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> report5 = new ArrayList<Country>();

            while (rset4.next()) {
                String code = rset4.getString("code");
                String name = rset4.getString("name");
                String continent = rset4.getString("continent");
                String region = rset4.getString("region");
                int surfaceArea = rset4.getInt("surfaceArea");
                int indepYear = rset4.getInt("indepYear");
                int population = rset4.getInt("population");
                int lifeExpectancy = rset4.getInt("lifeExpectancy");
                int gnp = rset4.getInt("gnp");
                int gnpOld = rset4.getInt("gnpOld");
                String localName = rset4.getString("localName");
                String governmentForm = rset4.getString("governmentForm");
                String headOfState = rset4.getString("headOfState");
                int capital = rset4.getInt("capital");
                String code2 = rset4.getString("code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                sb.append(country.toString() + "\r\n");
                report5.add(country);
            }
            // Displays the records
            return report5;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }

    }

    //Top n populated countries in Region

    public ArrayList<Country> TopPopulatedCountriesInRegion(int num, String reg) {

        System.out.println("Top n populated countries in Region");
        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql4 = "select * " +
                    "from country " +
                    "where Region = " + reg +
                    "Order By Population desc Limit " + num + ";";
            // Execute SQL statement
            ResultSet rset4 = stmt.executeQuery(sql4);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> report6 = new ArrayList<Country>();

            while (rset4.next()) {
                String code = rset4.getString("code");
                String name = rset4.getString("name");
                String continent = rset4.getString("continent");
                String region = rset4.getString("region");
                int surfaceArea = rset4.getInt("surfaceArea");
                int indepYear = rset4.getInt("indepYear");
                int population = rset4.getInt("population");
                int lifeExpectancy = rset4.getInt("lifeExpectancy");
                int gnp = rset4.getInt("gnp");
                int gnpOld = rset4.getInt("gnpOld");
                String localName = rset4.getString("localName");
                String governmentForm = rset4.getString("governmentForm");
                String headOfState = rset4.getString("headOfState");
                int capital = rset4.getInt("capital");
                String code2 = rset4.getString("code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                sb.append(country.toString() + "\r\n");
                report6.add(country);
            }
            // Displays the records
            return report6;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }

    }


    public ArrayList<City> citiesPopulation(String cName, int num) {

        System.out.println("All the cities in a district organised by largest population to smallest.\n\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            // All the cities in the world organised by largest population to smallest.
            String CitiesInWorld = "select * from city order by Population desc;";

            // All the cities in a continent organised by largest population to smallest
            String CitiesInContinent = "SELECT * \n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode=country.Code\n" +
                    "WHERE country.Continent = " + cName +
                    "ORDER BY city.Population DESC;";

            // All the cities in a region organised by largest population to smallest
            String CitiesInRegion = "SELECT * \n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode=country.Code\n" +
                    "WHERE country.Region = " + cName +
                    "ORDER BY city.Population DESC;";

            // All the cities in a country organised by largest population to smallest
            String CitiesInCountry = "SELECT * \n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode=country.Code\n" +
                    "WHERE country.Name = " + cName +
                    "ORDER BY city.Population DESC;";

            // All the cities in a district organised by largest population to smallest
            String CitiesInDistrict = "SELECT * \n" +
                    "FROM city\n" +
                    "WHERE city.District = " + cName +
                    "ORDER BY city.Population DESC;";

            ResultSet rset = null;

            if(num == 1)
            {
                rset = stmt.executeQuery(CitiesInWorld);
            }
            else if (num == 2)
            {
                rset = stmt.executeQuery(CitiesInContinent);
            }
            else if (num == 3)
            {
                rset = stmt.executeQuery(CitiesInRegion);
            }
            else if (num == 4)
            {
                rset = stmt.executeQuery(CitiesInCountry);
            }
            else if (num == 5)
            {
                rset = stmt.executeQuery(CitiesInDistrict);
            }

            // Check one is returned
            ArrayList<City> report9 = new ArrayList<City>();
            while (rset.next()) {
                int id = rset.getInt("id");
                String name = rset.getString("name");
                String countryCode = rset.getString("countryCode");
                String district = rset.getString("district");
                int population = rset.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                report9.add(city);
            }
            // Displays the records
            return report9;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }


    /*
    The top N populated cities in the world where N is provided by the user.
 */
    public ArrayList<City> TopCities(int num, int limit) {

        System.out.println("The top N populated cities in the world where N is provided by the user.\n\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String TopPopCitiesWorld = "SELECT * \n" +
                    "FROM city\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT "+ limit + ";";

            String TopPopCitiesContinent = "SELECT * \n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode = country.Code\n"+
                    "WHERE country.Continent = 'Africa'\n"+
                    "ORDER BY city.Population DESC\n"+
                    "LIMIT "+ limit + ";";

            String TopPopCitiesRegion = "SELECT * \n"+
                    "FROM city\n"+
                    "JOIN country ON city.CountryCode = country.Code\n"+
                    "WHERE country.Region = 'Southern and Central Asia'\n"+
                    "ORDER BY city.Population DESC\n"+
                    "LIMIT "+ limit + ";";

            String TopPopCitiesCountry = "SELECT * \n"+
                    "FROM city\n"+
                    "JOIN country ON city.CountryCode = country.Code\n"+
                    "WHERE country.Name = 'Bulgaria'\n"+
                    "ORDER BY city.Population DESC\n"+
                    "LIMIT "+ limit + ";";

            String TopPopCitiesDistrict = "SELECT * \n"+
                    "FROM city\n"+
                    "JOIN country ON city.CountryCode = country.Code\n"+
                    "WHERE city.District = 'Buenos Aires'\n"+
                    "ORDER BY city.Population DESC\n"+
                    "LIMIT "+ limit + ";";

            ResultSet rset = null;

            if(num == 1)
            {
                rset = stmt.executeQuery(TopPopCitiesWorld);
            }
            else if (num == 2)
            {
                rset = stmt.executeQuery(TopPopCitiesContinent);
            }
            else if (num == 3)
            {
                rset = stmt.executeQuery(TopPopCitiesRegion);
            }
            else if (num == 4)
            {
                rset = stmt.executeQuery(TopPopCitiesCountry);
            }
            else if (num == 5)
            {
                rset = stmt.executeQuery(TopPopCitiesDistrict);
            }

            // Execute SQL statement
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> report10 = new ArrayList<City>();

            while (rset.next()) {
                int id = rset.getInt("id");
                String name = rset.getString("name");
                String countryCode = rset.getString("countryCode");
                String district = rset.getString("district");
                int population = rset.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                report10.add(city);
            }
            // Displays the records
            return report10;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
            return null;
        }

    }

    public Country getCountry(String CName){

        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql = "select * \n" +
                    "from country\n " +
                    "WHERE country.Name = '"+CName+"';";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            // Return new country if valid.
            // Check one is returned
            if (rset.next()) {
                String code = rset.getString("code"); //MAKE SURE THIS WORKS, RANDOM
                String name = rset.getString("name");
                String continent = rset.getString("continent");
                String region = rset.getString("region");
                int surfaceArea = rset.getInt("surfaceArea");
                int indepYear = rset.getInt("indepYear");
                int population = rset.getInt("population");
                int lifeExpectancy = rset.getInt("lifeExpectancy");
                int gnp = rset.getInt("gnp");
                int gnpOld = rset.getInt("gnpOld");
                String localName = rset.getString("localName");
                String governmentForm = rset.getString("governmentForm");
                String headOfState = rset.getString("headOfState");
                int capital = rset.getInt("capital");
                String code2 = rset.getString("code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                return country;

            }
            else
                return null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public ArrayList<Country> getCountries() {

        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql12 = "SELECT * \n"+
                    "FROM country\n;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql12);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<Country> getCountries = new ArrayList<Country>();

            while (rset.next()) {
                String code = rset.getString("code");
                String name = rset.getString("name");
                String continent = rset.getString("continent");
                String region = rset.getString("region");
                int surfaceArea = rset.getInt("surfaceArea");
                int indepYear = rset.getInt("indepYear");
                int population = rset.getInt("population");
                int lifeExpectancy = rset.getInt("lifeExpectancy");
                int gnp = rset.getInt("gnp");
                int gnpOld = rset.getInt("gnpOld");
                String localName = rset.getString("localName");
                String governmentForm = rset.getString("governmentForm");
                String headOfState = rset.getString("headOfState");
                int capital = rset.getInt("capital");
                String code2 = rset.getString("code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                getCountries.add(country);
            }
            // Displays the records
            return getCountries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries details");
            return null;
        }

    }

    public ArrayList<City> getCities() {

        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql12 = "SELECT * \n"+
                    "FROM city\n;";

            // Execute SQL statement
            ResultSet rset12 = stmt.executeQuery(sql12);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> getCities = new ArrayList<City>();

            while (rset12.next()) {
                int id = rset12.getInt("id");
                String name = rset12.getString("name");
                String countryCode = rset12.getString("countryCode");
                String district = rset12.getString("district");
                int population = rset12.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                getCities.add(city);
            }
            // Displays the records
            return getCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }


    public City getCity(String Cname) {

        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql13 = "SELECT * \n"+
                    "FROM city\n" +
                    "WHERE city.Name = '"+Cname+"';";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql13);
            // Return new cities if valid.
            // Check one is returned

            if (rset.next())
            {
                int id = rset.getInt("id");
                String name = rset.getString("name");
                String countryCode = rset.getString("countryCode");
                String district = rset.getString("district");
                int population = rset.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                return city;
            }
            else
                return null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    public ArrayList<CountryLanguage> getCountryLanguages() {

        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql = "SELECT * \n"+
                    "FROM countrylanguage\n;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            // Return new cities if valid.
            // Check one is returned

            ArrayList<CountryLanguage> getCountryLanguages = new ArrayList<CountryLanguage>();


            while (rset.next()) {
                String code = rset.getString("CountryCode");
                String language = rset.getString("Language");
                String isOfficial = rset.getString("IsOfficial");
                int percentage = rset.getInt("Percentage");
                CountryLanguage countryLanguage = new CountryLanguage(code, language, isOfficial, percentage);
                getCountryLanguages.add(countryLanguage);
            }
            // Displays the records
            return getCountryLanguages;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }


    public static void printCities(ArrayList<City> cities)
    {
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.println(String.format("%-30s %-30s %-35s %-20s", "Name", "Country", "District", "Population"));
        // Loop over all countries in the list
        for (City city : cities)
        {
            if (city == null)
            {
                continue;
            }
            System.out.println(String.format("%-30s %-30s %-35s %-20s", city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation()));
        }
    }

    public ArrayList<Country> populationRank(String populationName, int num){

        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String worldPopulation = "select * from country order by Population desc;";
            String continentPopulation = "select * " +
                    "from country " +
                    "where continent = " + populationName +
                    "order by Population desc;";
            String regionPopulation = "select * " +
                    "from country " +
                    "where region = " + populationName +
                    "order by Population desc;";;
                    
            ResultSet rset = null;        
                    
            if(num == 1)
            {
                rset = stmt.executeQuery(worldPopulation);
            }
            else if (num == 2)
            {
                rset = stmt.executeQuery(continentPopulation);
            }
            else if (num == 3)
            {
                rset = stmt.executeQuery(regionPopulation);
            }
            // Execute SQL statement

            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> populationRank = new ArrayList<Country>();
            while (rset.next()) {
                String code = rset.getString("code");
                String name = rset.getString("name");
                String continent = rset.getString("continent");
                String region = rset.getString("region");
                int surfaceArea = rset.getInt("surfaceArea");
                int indepYear = rset.getInt("indepYear");
                int population = rset.getInt("population");
                int lifeExpectancy = rset.getInt("lifeExpectancy");
                int gnp = rset.getInt("gnp");
                int gnpOld = rset.getInt("gnpOld");
                String localName = rset.getString("localName");
                String governmentForm = rset.getString("governmentForm");
                String headOfState = rset.getString("headOfState");
                int capital = rset.getInt("capital");
                String code2 = rset.getString("code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                populationRank.add(country);
            }
            // Displays the records
            return populationRank;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    public static void printCountries(ArrayList<Country> Countries)
    {
        // Check countries is not null
        if (Countries == null)
        {
            System.out.println("No countries");
            return;
        }

        // Print header
        String format = String.format("%-40s %-40s %-40s %-40s %-40s %-40s", "Code", "Name", "Continent", "Region", "Population", "Capital");
        System.out.println(format);
        // Loop over all countries in the list
        for (Country country : Countries)
        {
            if (country == null)
                continue;
            String cnt_string =
                    String.format("%-40s %-40s %-40s %-40s %-40s %-40s",
                            country.getCode(), country.getName(), country.getContinent(), country.getRegion(), country.getPopulation(), country.getCapital());
            System.out.println(cnt_string);
        }
    }


    public ArrayList<Country> reportCapitalPopulation1() {
        System.out.println("All the capital cities in the world organised by largest population to smallest \n\n");
        StringBuilder sb = new StringBuilder();
        try {
            //Create an SQL statement
            Statement stmt = con.createStatement();
            //create string for SQL statement
            String sqlCP1 = "SELECT Capital FROM country ORDER BY Population DESC;";
            // execute SQL statement
            ResultSet resultCP1 = stmt.executeQuery(sqlCP1);
            // return capital cities if valid
            // check on is returned
            ArrayList<Country> reportCP1 = new ArrayList<Country>();

            while (resultCP1.next()) {
                String code = resultCP1.getString("code"); //MAKE SURE THIS WORKS, RANDOM
                String name = resultCP1.getString("name");
                String continent = resultCP1.getString("continent");
                String region = resultCP1.getString("region");
                Integer surfaceArea = resultCP1.getInt("surfaceArea");
                Integer indepYear = resultCP1.getInt("indepYear");
                Integer population = resultCP1.getInt("population");
                Integer lifeExpectancy = resultCP1.getInt("lifeExpectancy");
                Integer gnp = resultCP1.getInt("gnp");
                Integer gnpOld = resultCP1.getInt("gnpOld");
                String localName = resultCP1.getString("localName");
                String governmentForm = resultCP1.getString("governmentForm");
                String headOfState = resultCP1.getString("headOfState");
                Integer capital = resultCP1.getInt("capital");
                String code2 = resultCP1.getString("code2");
                Country countries = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                reportCP1.add(countries);
            }
            //Display the record
            return reportCP1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details organised by largest to smallest population \n\n");
            return null;
        }
    }

    public ArrayList<Country> reportCapitalPopulation2(String userContinent) {
        System.out.println("All the capital cities in a continent organised by largest population to smallest \n\n");
        StringBuilder sb = new StringBuilder();
        try {
            //Create an SQL statement
            Statement stmt = con.createStatement();
            //create string for SQL statement
            String sqlCP2 = "SELECT Capital FROM country WHERE Continent = " + userContinent + " ORDER BY Population DESC;";
            // execute SQL statement
            ResultSet resultCP2 = stmt.executeQuery(sqlCP2);
            // return capital cities if valid
            // check on is returned
            ArrayList<Country> reportCP2 = new ArrayList<Country>();

            while (resultCP2.next()) {
                String code = resultCP2.getString("code"); //MAKE SURE THIS WORKS, RANDOM
                String name = resultCP2.getString("name");
                String continent = resultCP2.getString("continent");
                String region = resultCP2.getString("region");
                Integer surfaceArea = resultCP2.getInt("surfaceArea");
                Integer indepYear = resultCP2.getInt("indepYear");
                Integer population = resultCP2.getInt("population");
                Integer lifeExpectancy = resultCP2.getInt("lifeExpectancy");
                Integer gnp = resultCP2.getInt("gnp");
                Integer gnpOld = resultCP2.getInt("gnpOld");
                String localName = resultCP2.getString("localName");
                String governmentForm = resultCP2.getString("governmentForm");
                String headOfState = resultCP2.getString("headOfState");
                Integer capital = resultCP2.getInt("capital");
                String code2 = resultCP2.getString("code2");
                Country countries = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                reportCP2.add(countries);
            }
            //Display the record
            return reportCP2;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get all the capital cities in a continent organised by largest population to smallest \n\n");
            return null;
        }
    }

    public ArrayList<Country> reportCapitalPopulation3(String userRegion) {
        System.out.println("All the capital cities in a region organised by largest population to smallest \n\n");
        StringBuilder sb = new StringBuilder();
        try {
            //Create an SQL statement
            Statement stmt = con.createStatement();
            //create string for SQL statement
            String sqlCP3 = "SELECT Capital FROM country WHERE Region = " + userRegion + " ORDER BY Population DESC;";
            // execute SQL statement
            ResultSet resultCP3 = stmt.executeQuery(sqlCP3);
            // return capital cities if valid
            // check on is returned
            ArrayList<Country> reportCP3 = new ArrayList<Country>();

            while (resultCP3.next()) {
                String code = resultCP3.getString("code"); //MAKE SURE THIS WORKS, RANDOM
                String name = resultCP3.getString("name");
                String continent = resultCP3.getString("continent");
                String region = resultCP3.getString("region");
                Integer surfaceArea = resultCP3.getInt("surfaceArea");
                Integer indepYear = resultCP3.getInt("indepYear");
                Integer population = resultCP3.getInt("population");
                Integer lifeExpectancy = resultCP3.getInt("lifeExpectancy");
                Integer gnp = resultCP3.getInt("gnp");
                Integer gnpOld = resultCP3.getInt("gnpOld");
                String localName = resultCP3.getString("localName");
                String governmentForm = resultCP3.getString("governmentForm");
                String headOfState = resultCP3.getString("headOfState");
                Integer capital = resultCP3.getInt("capital");
                String code2 = resultCP3.getString("code2");
                Country countries = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                reportCP3.add(countries);
            }
            //Display the record
            return reportCP3;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get all the capital cities in a region organised by largest population to smallest \n\n");
            return null;
        }
    }

    public ArrayList<Country> topCapital1(int topNPopulatedCapitalCities) {
        System.out.println("The top N populated capital cities in the world where N is provided by the user \n\n");
        StringBuilder sb = new StringBuilder();
        try {
            //Create an SQL statement
            Statement stmt = con.createStatement();
            //create string for SQL statement
            String sqlTC1 = "SELECT Capital FROM country ORDER BY Population DESC LIMIT " + topNPopulatedCapitalCities + ";";
            // execute SQL statement
            ResultSet resultTC1 = stmt.executeQuery(sqlTC1);
            // return capital cities if valid
            // check on is returned
            ArrayList<Country> reportTC1 = new ArrayList<Country>();

            while (resultTC1.next()) {
                Country countries = new Country(resultTC1.getString("code"), resultTC1.getString("name"), resultTC1.getString("continent"),
                        resultTC1.getString("region"), resultTC1.getInt("surfaceArea"), resultTC1.getInt("indepYear"), resultTC1.getInt("population"),
                        resultTC1.getInt("lifeExpectancy"), resultTC1.getInt("gnp"), resultTC1.getInt("gnpOld"),
                        resultTC1.getString("localName"), resultTC1.getString("governmentForm"), resultTC1.getString("headOfState"), resultTC1.getInt("capital"), resultTC1.getString("code2"));
                reportTC1.add(countries);
            }
            //Display the record
            return reportTC1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to the top N populated capital cities in the world where N is provided by the user \n\n");
            return null;
        }
    }

    public ArrayList<Country> topCapital2(int topNPopulatedCapitalCities, String userContinent) {
        System.out.println("The top N populated capital cities in a continent where N is provided by the user \n\n");
        StringBuilder sb = new StringBuilder();
        try {
            //Create an SQL statement
            Statement stmt = con.createStatement();
            //create string for SQL statement
            String sqlTC2 = "SELECT Capital FROM country WHERE Continent = " + userContinent + " ORDER BY Population DESC LIMIT " + topNPopulatedCapitalCities + ";";
            // execute SQL statement
            ResultSet resultTC2 = stmt.executeQuery(sqlTC2);
            // return capital cities if valid
            // check on is returned
            ArrayList<Country> reportTC2 = new ArrayList<Country>();

            while (resultTC2.next()) {
                Country countries = new Country(resultTC2.getString("code"), resultTC2.getString("name"), resultTC2.getString("continent"),
                        resultTC2.getString("region"), resultTC2.getInt("surfaceArea"), resultTC2.getInt("indepYear"), resultTC2.getInt("population"),
                        resultTC2.getInt("lifeExpectancy"), resultTC2.getInt("gnp"), resultTC2.getInt("gnpOld"),
                        resultTC2.getString("localName"), resultTC2.getString("governmentForm"), resultTC2.getString("headOfState"), resultTC2.getInt("capital"), resultTC2.getString("code2"));
                reportTC2.add(countries);
            }
            //Display the record
            return reportTC2;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to the top N populated capital cities in the world where N is provided by the user \n\n");
            return null;
        }
    }

    public ArrayList<Country> topCapital3(int topNPopulatedCapitalCities, String userRegion) {
        System.out.println("The top N populated capital cities in a region where N is provided by the user.  \n\n");
        StringBuilder sb = new StringBuilder();
        try {
            //Create an SQL statement
            Statement stmt = con.createStatement();
            //create string for SQL statement
            String sqlTC3 = "SELECT Capital FROM country WHERE Region = " + userRegion + " ORDER BY Population DESC LIMIT " + topNPopulatedCapitalCities + ";";
            // execute SQL statement
            ResultSet resultTC3 = stmt.executeQuery(sqlTC3);
            // return capital cities if valid
            // check on is returned
            ArrayList<Country> reportTC3 = new ArrayList<Country>();

            while (resultTC3.next()) {
                Country countries = new Country(resultTC3.getString("code"), resultTC3.getString("name"), resultTC3.getString("continent"),
                        resultTC3.getString("region"), resultTC3.getInt("surfaceArea"), resultTC3.getInt("indepYear"), resultTC3.getInt("population"),
                        resultTC3.getInt("lifeExpectancy"), resultTC3.getInt("gnp"), resultTC3.getInt("gnpOld"),
                        resultTC3.getString("localName"), resultTC3.getString("governmentForm"), resultTC3.getString("headOfState"), resultTC3.getInt("capital"), resultTC3.getString("code2"));
                reportTC3.add(countries);
            }
            //Display the record
            return reportTC3;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to The top N populated capital cities in a region where N is provided by the user. \n\n");
            return null;
        }
    }

    public static void main(String[] args) {
        // Create new Application
        App a = new App();


        // ------------------ Testing -------------------------------
        if(args.length < 1){
            a.connect("localhost:33060", 0);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // ---------------------------------------------------------


//        ArrayList<Country> populationRank = a.populationRank("'Europe'", 2);
//        a.printCountries(populationRank);
//
//        ArrayList<Country> getCountries = a.getCountries();
//
//        ArrayList<City> getCities = a.getCities();
//        printCities(getCities);
//
//        ArrayList<CountryLanguage> getCountryLanguages = a.getCountryLanguages();
//
//        ArrayList<City> CitiesPopulation = a.citiesPopulation("'Europe'", 2);
//        printCities(CitiesPopulation);
//
//        ArrayList<City> TopCities = a.TopCities(1, 5);
//        printCities(TopCities);
//
//
//        // Display the Records
//
        a.countriesInWorldLargestToSmallest();
        a.countriesInContinentLargestToSmallest("'Asia'");
        a.countriesInRegionLargestToSmallest("'Caribbean'");
        a.TopPopulatedCountriesInWorld(5);
        a.TopPopulatedCountriesInContinent(5, "'Asia'");
        a.TopPopulatedCountriesInRegion(3, "'Caribbean'");

//        // Display all the cities in the world organised by largest population to smallest.
//        a.CitiesInTheWorldLargestPopulationToSmallest();
//
//        // Display all the cities in a continent organised by largest population to smallest.
//        a.CitiesInContinentLargestToSmallest("'Europe'");
//
//        // Display all the cities in a region organised by largest population to smallest.
//        a.CitiesInRegionLargestToSmallest("'Middle East'");
//
//        // Display All the cities in a country organised by largest population to smallest.
//        a.CitiesInCountryLargestToSmallest("'Netherlands'");
//
//        // Display All the cities in a district organised by largest population to smallest.
//        a.CitiesInDistrictLargestToSmallest("'Buenos Aires'");
//
//// Display all the capital cities in the world organised by largest population to smallest.
//        ArrayList<Country> reportCP1 = a.reportCapitalPopulation1(); // FILL IN ANSWER *NOTE FOR SAM*
//
        // Display all the capital cities in a continent organised by largest population to smallest.
        ArrayList<Country> reportCP2 = a.reportCapitalPopulation2( "'Africa'"); // FILL IN ANSWER *NOTE FOR SAM*

        // Display all the capital cities in a region organised by largest population to smallest.
        ArrayList<Country> reportCP3 = a.reportCapitalPopulation3( "'Caribbean'" ); // FILL IN ANSWER *NOTE FOR SAM*

        //Display top N populated capital cities in the world where N is provided by the user.
        ArrayList<Country> reportTC1 = a.topCapital1(5 ); // FILL IN ANSWER *NOTE FOR SAM*

        //Display top N populated capital cities in the world where N is provided by the user.
        ArrayList<Country> reportTC2 = a.topCapital2( 3, "'Asia'"); // FILL IN ANSWER *NOTE FOR SAM*

        //Display top N populated capital cities in the world where N is provided by the user.
        ArrayList<Country> reportTC3 = a.topCapital3( 4, "'Caribbean"); // FILL IN ANSWER *NOTE FOR SAM*


        // Disconnect from database
        a.disconnect();
    }

}


