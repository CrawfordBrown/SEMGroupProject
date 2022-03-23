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
                Integer surfaceArea = rset.getInt("surfaceArea");
                Integer indepYear = rset.getInt("indepYear");
                Integer population = rset.getInt("population");
                Integer lifeExpectancy = rset.getInt("lifeExpectancy");
                Integer gnp = rset.getInt("gnp");
                Integer gnpOld = rset.getInt("gnpOld");
                String localName = rset.getString("localName");
                String governmentForm = rset.getString("governmentForm");
                String headOfState = rset.getString("headOfState");
                Integer capital = rset.getInt("capital");
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
                Integer surfaceArea = rset2.getInt("surfaceArea");
                Integer indepYear = rset2.getInt("indepYear");
                Integer population = rset2.getInt("population");
                Integer lifeExpectancy = rset2.getInt("lifeExpectancy");
                Integer gnp = rset2.getInt("gnp");
                Integer gnpOld = rset2.getInt("gnpOld");
                String localName = rset2.getString("localName");
                String governmentForm = rset2.getString("governmentForm");
                String headOfState = rset2.getString("headOfState");
                Integer capital = rset2.getInt("capital");
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
                Integer surfaceArea = rset3.getInt("surfaceArea");
                Integer indepYear = rset3.getInt("indepYear");
                Integer population = rset3.getInt("population");
                Integer lifeExpectancy = rset3.getInt("lifeExpectancy");
                Integer gnp = rset3.getInt("gnp");
                Integer gnpOld = rset3.getInt("gnpOld");
                String localName = rset3.getString("localName");
                String governmentForm = rset3.getString("governmentForm");
                String headOfState = rset3.getString("headOfState");
                Integer capital = rset3.getInt("capital");
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
                Integer surfaceArea = rset4.getInt("surfaceArea");
                Integer indepYear = rset4.getInt("indepYear");
                Integer population = rset4.getInt("population");
                Integer lifeExpectancy = rset4.getInt("lifeExpectancy");
                Integer gnp = rset4.getInt("gnp");
                Integer gnpOld = rset4.getInt("gnpOld");
                String localName = rset4.getString("localName");
                String governmentForm = rset4.getString("governmentForm");
                String headOfState = rset4.getString("headOfState");
                Integer capital = rset4.getInt("capital");
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
                Integer surfaceArea = rset4.getInt("surfaceArea");
                Integer indepYear = rset4.getInt("indepYear");
                Integer population = rset4.getInt("population");
                Integer lifeExpectancy = rset4.getInt("lifeExpectancy");
                Integer gnp = rset4.getInt("gnp");
                Integer gnpOld = rset4.getInt("gnpOld");
                String localName = rset4.getString("localName");
                String governmentForm = rset4.getString("governmentForm");
                String headOfState = rset4.getString("headOfState");
                Integer capital = rset4.getInt("capital");
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
                Integer surfaceArea = rset4.getInt("surfaceArea");
                Integer indepYear = rset4.getInt("indepYear");
                Integer population = rset4.getInt("population");
                Integer lifeExpectancy = rset4.getInt("lifeExpectancy");
                Integer gnp = rset4.getInt("gnp");
                Integer gnpOld = rset4.getInt("gnpOld");
                String localName = rset4.getString("localName");
                String governmentForm = rset4.getString("governmentForm");
                String headOfState = rset4.getString("headOfState");
                Integer capital = rset4.getInt("capital");
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



    public ArrayList<City> CitiesInTheWorldLargestPopulationToSmallest() {

        System.out.println("All the cities in the world organised by largest population to smallest.");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql5 = "select * from city order by Population desc;";
            // Execute SQL statement
            ResultSet rset5 = stmt.executeQuery(sql5);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> report5 = new ArrayList<City>();
            while (rset5.next()) {

                Integer id = rset5.getInt("id");
                String name = rset5.getString("name");
                String countryCode = rset5.getString("countryCode");
                String district = rset5.getString("district");
                Integer population = rset5.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                report5.add(city);
            }
            // Displays the records
            return report5;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }
    /*
    All the cities in a continent organised by largest population to smallest.
     */

    public ArrayList<City> CitiesInContinentLargestToSmallest(String cont) {

        System.out.println("All the cities in a continent organised by largest population to smallest.\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql6 = "SELECT * \n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode=country.Code\n" +
                    "WHERE country.Continent = " + cont +
                    "ORDER BY city.Population DESC;";
            // Execute SQL statement
            ResultSet rset6 = stmt.executeQuery(sql6);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> report6 = new ArrayList<City>();
            while (rset6.next()) {
                Integer id = rset6.getInt("id");
                String name = rset6.getString("name");
                String countryCode = rset6.getString("countryCode");
                String district = rset6.getString("district");
                Integer population = rset6.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                report6.add(city);
            }
            // Displays the records
            return report6;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /*
        All the cities in a region organised by largest population to smallest.
     */

    public ArrayList<City> CitiesInRegionLargestToSmallest(String reg) {

        System.out.println("All the cities in a region organised by largest population to smallest.");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql7 = "SELECT * \n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode=country.Code\n" +
                    "WHERE country.Region = " + reg +
                    "ORDER BY city.Population DESC;";
            // Execute SQL statement
            ResultSet rset7 = stmt.executeQuery(sql7);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> report7 = new ArrayList<City>();
            while (rset7.next()) {
                Integer id = rset7.getInt("id");
                String name = rset7.getString("name");
                String countryCode = rset7.getString("countryCode");
                String district = rset7.getString("district");
                Integer population = rset7.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                report7.add(city);
            }
            // Displays the records
            return report7;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /*
    All the cities in a country organised by largest population to smallest.
     */

    public ArrayList<City> CitiesInCountryLargestToSmallest(String coutry) {

        System.out.println("All the cities in a country organised by largest population to smallest.\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql8 = "SELECT * \n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode=country.Code\n" +
                    "WHERE country.Name = " + coutry +
                    "ORDER BY city.Population DESC;";
            // Execute SQL statement
            ResultSet rset8 = stmt.executeQuery(sql8);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> report8 = new ArrayList<City>();
            while (rset8.next()) {
                Integer id = rset8.getInt("id");
                String name = rset8.getString("name");
                String countryCode = rset8.getString("countryCode");
                String district = rset8.getString("district");
                Integer population = rset8.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                report8.add(city);
            }
            // Displays the records
            return report8;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /*
        All the cities in a district organised by largest population to smallest.
     */

    public ArrayList<City> CitiesInDistrictLargestToSmallest(String dist) {

        System.out.println("All the cities in a district organised by largest population to smallest.\n\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql9 = "SELECT * \n" +
                    "FROM city\n" +
                    "WHERE city.District = " + dist +
                    "ORDER BY city.Population DESC;";
            // Execute SQL statement
            ResultSet rset9 = stmt.executeQuery(sql9);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> report9 = new ArrayList<City>();
            while (rset9.next()) {
                Integer id = rset9.getInt("id");
                String name = rset9.getString("name");
                String countryCode = rset9.getString("countryCode");
                String district = rset9.getString("district");
                Integer population = rset9.getInt("population");
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
    public ArrayList<City> TopNpopulatedCities(int num) {

        System.out.println("The top N populated cities in the world where N is provided by the user.\n\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql10 = "SELECT * \n" +
                    "FROM city\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT "+ num + ";";
            // Execute SQL statement
            ResultSet rset10 = stmt.executeQuery(sql10);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> report10 = new ArrayList<City>();

            while (rset10.next()) {
                Integer id = rset10.getInt("id");
                String name = rset10.getString("name");
                String countryCode = rset10.getString("countryCode");
                String district = rset10.getString("district");
                Integer population = rset10.getInt("population");
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

    /*
    The Top N populated cities in a continent where N is provided by the user.
    */
    public ArrayList<City> TopNpopulatedCitiesInContient(int num) {

        System.out.println("the top N populated cities in a continent where N is provided by the user.\n\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql11 = "SELECT * \n" +
                    "FROM city\n" +
                    "LEFT JOIN country ON city.CountryCode = country.Code\n"+
                    "WHERE country.Continent = 'Africa'\n"+
                    "ORDER BY city.Population DESC\n"+
                    "LIMIT "+ num + ";";
            // Execute SQL statement
            ResultSet rset11 = stmt.executeQuery(sql11);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> report11 = new ArrayList<City>();

            while (rset11.next()) {
                Integer id = rset11.getInt("id");
                String name = rset11.getString("name");
                String countryCode = rset11.getString("countryCode");
                String district = rset11.getString("district");
                Integer population = rset11.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                report11.add(city);
            }
            // Displays the records
            return report11;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /*
        The Top N populated cities in a region where N is provided by the user
    */
    public ArrayList<City> TopNpopulationCitiesInRegion(int num) {

        System.out.println("The Top N populated cities in a region where N is provided by the user.\n\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql12 = "SELECT * \n"+
                    "FROM city\n"+
                    "JOIN country ON city.CountryCode = country.Code\n"+
                    "WHERE country.Region = 'Southern and Central Asia'\n"+
                    "ORDER BY city.Population DESC\n"+
                    "LIMIT "+ num + ";";

            // Execute SQL statement
            ResultSet rset12 = stmt.executeQuery(sql12);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> report12 = new ArrayList<City>();

            while (rset12.next()) {
                Integer id = rset12.getInt("id");
                String name = rset12.getString("name");
                String countryCode = rset12.getString("countryCode");
                String district = rset12.getString("district");
                Integer population = rset12.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                report12.add(city);
            }
            // Displays the records
            return report12;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    public ArrayList<Country> getCountry(String countryname){

        StringBuilder sb  = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql = "select * from country ;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> getCountries = new ArrayList<Country>();
            while (rset.next()) {
                String code = rset.getString("code"); //MAKE SURE THIS WORKS, RANDOM
                String name = rset.getString("name");
                String continent = rset.getString("continent");
                String region = rset.getString("region");
                Integer surfaceArea = rset.getInt("surfaceArea");
                Integer indepYear = rset.getInt("indepYear");
                Integer population = rset.getInt("population");
                Integer lifeExpectancy = rset.getInt("lifeExpectancy");
                Integer gnp = rset.getInt("gnp");
                Integer gnpOld = rset.getInt("gnpOld");
                String localName = rset.getString("localName");
                String governmentForm = rset.getString("governmentForm");
                String headOfState = rset.getString("headOfState");
                Integer capital = rset.getInt("capital");
                String code2 = rset.getString("code2");
                Country country = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                getCountries.add(country);

            }
            return getCountries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public ArrayList<City> getCities(String cityname) {

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
                Integer id = rset12.getInt("id");
                String name = rset12.getString("name");
                String countryCode = rset12.getString("countryCode");
                String district = rset12.getString("district");
                Integer population = rset12.getInt("population");
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

        a.getCountry("Spain");

        ArrayList<City> getCities = a.getCities("Bombay");

        // Display the Records

          a.countriesInWorldLargestToSmallest();
//        a.countriesInContinentLargestToSmallest("'Asia'");
//        a.countriesInRegionLargestToSmallest("'Caribbean'");
//        a.TopPopulatedCountriesInWorld(5);
      //  a.TopPopulatedCountriesInContinent(5, "'Asia'");
       // a.TopPopulatedCountriesInRegion(3, "'Caribbean'");

        // Display all the cities in the world organised by largest population to smallest.
//        a.CitiesInTheWorldLargestPopulationToSmallest();
//
//        // Display all the cities in a continent organised by largest population to smallest.
//        a.report6("'Europe'");
//
//        // Display all the cities in a region organised by largest population to smallest.
//        a.report7("'Middle East'");
//
//        // Display All the cities in a country organised by largest population to smallest.
//        a.report8("'Netherlands'");
//
//        // Display All the cities in a district organised by largest population to smallest.
//        a.report9("'Buenos Aires'");

        // Disconnect from database
        a.disconnect();
    }

}


