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

    //TopPopulation

    public ArrayList<Country> TopPopulation(String populated_countries, int limit, int num) {

        System.out.println("TopPopulation\n");
        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String TopPopulationWorld = "select * " +
                    "from country " +
                    "Order By Population desc Limit " + limit + ";";

            String TopPopulationContinent = "select * " +
                    "from country " +
                    "where Continent = " + populated_countries +
                    "Order By Population desc Limit " + limit + ";";

            String TopPopulationRegion = "select * " +
                    "from country " +
                    "where Region = " + populated_countries +
                    "Order By Population desc Limit " + limit + ";";

            ResultSet rset = null;

            if(num == 1)
            {
                rset = stmt.executeQuery(TopPopulationWorld);
            }
            else if (num == 2)
            {
                rset = stmt.executeQuery(TopPopulationContinent);
            }
            else if (num == 3)
            {
                rset = stmt.executeQuery(TopPopulationRegion);
            }

            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> report4 = new ArrayList<Country>();

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

    public ArrayList<City> citiesPopulation(String cName, int num) {

        System.out.println("Cities Population\n");
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

        //System.out.println("TopCities\n");
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



    public ArrayList<City> capitalPopulation(String capitalName, int num){

        System.out.println("capitalPopulation");
        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sqlCP1 = "SELECT ID, city.Name, country.name, District, city.Population " +
                    "FROM city JOIN country ON (country.code = city.CountryCode) WHERE (Capital = ID)" +
                    " ORDER BY city.Population DESC";

            String sqlCP2 = "SELECT ID, city.Name, country.name, District, city.Population " +
                    "FROM city JOIN country ON (country.code = city.CountryCode) WHERE (Capital = ID) && continent = '" + capitalName +
                    "' ORDER BY city.Population DESC";

            String regionPopulation = "SELECT ID, city.Name, country.name, District, city.Population " +
                    "FROM city JOIN country ON (country.code = city.CountryCode) WHERE (Capital = ID) && Region = '" + capitalName +
                    "' ORDER BY city.Population DESC";

            ResultSet rset = null;

            if(num == 1)
            {
                rset = stmt.executeQuery(sqlCP1);
            }
            else if (num == 2)
            {
                rset = stmt.executeQuery(sqlCP2);
            }
            else if (num == 3)
            {
                rset = stmt.executeQuery(regionPopulation);
            }
            // Execute SQL statement

            // Return new country if valid.
            // Check one is returned
            ArrayList<City> capitalPopulation = new ArrayList<>();
            while (rset.next()) {
                int id = rset.getInt("id");
                String name = rset.getString("name");
                String countryCode = rset.getString("countryCode");
                String district = rset.getString("district");
                int population = rset.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                capitalPopulation.add(city);
            }
            // Displays the records
            return capitalPopulation;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public ArrayList<Country> populationRank(String populationName, int num){

        System.out.println("PopulationRank");
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

    public void WritesCities(ArrayList<City> cities, String filename)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header

        sb.append("| Name | Country | District | Population | \r\n");
        sb.append("| --- | --- | --- | --- |\r\n");

        //System.out.println(String.format("%-30s %-30s %-35s %-20s", "Name", "Country", "District", "Population"));
        // Loop over all cities in the list
        for (City city : cities) {
            if (city == null) continue;

            sb.append("| " + city.getName() + " | " +
                    city.getCountryCode() + " | " + city.getDistrict() + " | " +
                    city.getPopulation() + " |\r\n");
        }
        try{
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
            writer.write(sb.toString());
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
            //System.out.println(String.format("%-30s %-30s %-35s %-20s", city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation()));

    }

    public void printCities(ArrayList<City> cities)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header

        sb.append("| Name | Country | District | Population | \r\n");
        sb.append("| --- | --- | --- | --- |\r\n");

        //System.out.println(String.format("%-30s %-30s %-35s %-20s", "Name", "Country", "District", "Population"));
        // Loop over all cities in the list
        for (City city : cities) {
            if (city == null) {
                continue;
            }
            sb.append("| " + city.getName() + " | " +
                    city.getCountryCode() + " | " + city.getDistrict() + " | " +
                    city.getPopulation() + " |\r\n");
        }
        //System.out.println(String.format("%-30s %-30s %-35s %-20s", city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation()));

    }

    public void printCountries(ArrayList<Country> Countries)
    {
        // Check countries is not null
        if (Countries == null)
        {
            System.out.println("No countries");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header

        sb.append("| Code | Name | Continent | Region | Population | Capital | \r\n");
        sb.append("| --- | --- | --- | --- | --- | --- |\r\n");

        // Loop over all countries in the list
        for (Country country : Countries) {
            if (country == null) {
                continue;
            }
            sb.append("| " + country.getCode() + " | " +
                    country.getName() + " | " +
                    country.getContinent() + " | " +
                    country.getRegion() + " | " +
                    country.getPopulation() + " | " +
                    country.getCapital() + "|\r\n");
        }

    }

    public void WritesCountries(ArrayList<Country> Countries, String filename)
    {
        // Check countries is not null
        if (Countries == null)
        {
            System.out.println("No countries");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header

        sb.append("| Code | Name | Continent | Region | Population | Capital | \r\n");
        sb.append("| --- | --- | --- | --- | --- | --- |\r\n");

        // Loop over all countries in the list
        for (Country country : Countries) {
            if (country == null) continue;
            sb.append("| " + country.getCode() + " | " +
                    country.getName() + " | " +
                    country.getContinent() + " | " +
                    country.getRegion() + " | " +
                    country.getPopulation() + " | " +
                    country.getCapital() + "|\r\n");
        }
        try{
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter("./reports/" + filename));
            writer.write(sb.toString());
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
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

        // Population Rank
        ArrayList<Country> worldPopulation = a.populationRank("", 1);
        a.WritesCountries(worldPopulation, "WorldPopulation.md");

        ArrayList<Country> continentPopulation = a.populationRank("'Asia'", 2);
        a.WritesCountries(continentPopulation, "ContinentPopulation.md");

        ArrayList<Country> regionPopulation = a.populationRank("'North America'", 3);
        a.WritesCountries(regionPopulation, "RegionPopulation.md");
        // ------------------------------------------------------------------------------------------ //

        // TopPopulation
        ArrayList<Country> TopPopulationWorld = a.TopPopulation("", 5,1);
        a.WritesCountries(TopPopulationWorld, "TopPopulationWorld.md");

        ArrayList<Country> TopPopulationContinent = a.TopPopulation("'Asia'", 5 , 2);
        a.WritesCountries(TopPopulationContinent, "TopPopulationContinent.md");

        ArrayList<Country> TopPopulationRegion = a.TopPopulation("'North America'", 5 , 3);
        a.WritesCountries(TopPopulationRegion, "TopPopulationRegion.md");

        // ------------------------------------------------------------------------------------------ //

        // CitiesPopulation
        ArrayList<City> CitiesInWorld = a.citiesPopulation("",1);
        a.WritesCities(CitiesInWorld, "CitiesInWorld.md");

        ArrayList<City> CitiesInContinent = a.citiesPopulation("'Asia'",2);
        a.WritesCities(CitiesInContinent, "CitiesInContinent.md");

        ArrayList<City> CitiesInRegion = a.citiesPopulation("'North America'",3);
        a.WritesCities(CitiesInRegion, "CitiesInRegion.md");

        ArrayList<City> CitiesInCountry = a.citiesPopulation("'United States'",4);
        a.WritesCities(CitiesInCountry, "CitiesInCountry.md");

        ArrayList<City> CitiesInDistrict = a.citiesPopulation("'California'",5);
        a.WritesCities(CitiesInDistrict, "CitiesInDistrict.md");


        // ------------------------------------------------------------------------------------------ //

        // capitalPopulation
        ArrayList<City> CapitalCitiesWorld = a.capitalPopulation("", 1);
        a.WritesCities(CapitalCitiesWorld, "CapitalCitiesWorld.md");

        ArrayList<City> CapitalCitiesContinent = a.capitalPopulation("'Asia'", 2);
        a.WritesCities(CapitalCitiesContinent, "CapitalCitiesContinent.md");

        ArrayList<City> CapitalCitiesRegion = a.capitalPopulation("'North America'", 3);
        a.WritesCities(CapitalCitiesRegion, "CapitalCitiesRegion.md");

        // ------------------------------------------------------------------------------------------ //

        // TopCapital

        // ------------------------------------------------------------------------------------------ //



        ArrayList<Country> getCountries = a.getCountries();

        ArrayList<City> getCities = a.getCities();
       // a.printCities(getCities);

        ArrayList<CountryLanguage> getCountryLanguages = a.getCountryLanguages();


        ArrayList<City> TopCities = a.TopCities(1, 5);
        //a.printCities(TopCities);


        // Disconnect from database
        a.disconnect();
    }

}


