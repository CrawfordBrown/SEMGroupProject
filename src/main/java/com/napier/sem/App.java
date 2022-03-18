package com.napier.sem;

import java.sql.*;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
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

    private void countriesInWorldLargestToSmallest() {

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
            }
            // Displays the records
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return;
        }

    }

     /*
    All the countries in a continent organised by largest population to smallest
     */

    private void countriesInContinentLargestToSmallest(String cont) {

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
            }
            // Displays the records
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return;
        }

    }


    //All the countries in a Region organised by largest population to smallest

    private void countriesInRegionLargestToSmallest(String reg) {

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
            }
            // Displays the records
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return;
        }

    }

    //Top n populated countries in world

    private void TopPopulatedCountriesInWorld(int num) {

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
            }
            // Displays the records
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return;
        }

    }//Top n populated countries in continent

    private void TopPopulatedCountriesInContinent(int num, String cont) {

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
            }
            // Displays the records
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return;
        }

    }



    private void report5() {

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
            while (rset5.next()) {

                Integer id = rset5.getInt("id");
                String name = rset5.getString("name");
                String countryCode = rset5.getString("countryCode");
                String district = rset5.getString("district");
                Integer population = rset5.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                sb.append(city.toString() + "\r\n");
            }
            // Displays the records

            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return;
        }

    }
    /*
    All the cities in a continent organised by largest population to smallest.
     */

    private void report6(String cont) {

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
            while (rset6.next()) {
                Integer id = rset6.getInt("id");
                String name = rset6.getString("name");
                String countryCode = rset6.getString("countryCode");
                String district = rset6.getString("district");
                Integer population = rset6.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                sb.append(city.toString() + "\r\n");
            }
            // Displays the records
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return;
        }

    }

    /*
        All the cities in a region organised by largest population to smallest.
     */

    private void report7(String reg) {

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
            while (rset7.next()) {
                Integer id = rset7.getInt("id");
                String name = rset7.getString("name");
                String countryCode = rset7.getString("countryCode");
                String district = rset7.getString("district");
                Integer population = rset7.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                sb.append(city.toString() + "\r\n");
            }
            // Displays the records
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return;
        }

    }

    /*
    All the cities in a country organised by largest population to smallest.
     */

    private void report8(String coutry) {

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
            while (rset8.next()) {
                Integer id = rset8.getInt("id");
                String name = rset8.getString("name");
                String countryCode = rset8.getString("countryCode");
                String district = rset8.getString("district");
                Integer population = rset8.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                sb.append(city.toString() + "\r\n");
            }
            // Displays the records
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return;
        }

    }

    /*
        All the cities in a district organised by largest population to smallest.
     */

    private void report9(String dist) {

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
            while (rset9.next()) {
                Integer id = rset9.getInt("id");
                String name = rset9.getString("name");
                String countryCode = rset9.getString("countryCode");
                String district = rset9.getString("district");
                Integer population = rset9.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                sb.append(city.toString() + "\r\n");
            }
            // Displays the records
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return;
        }

    }

    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Display the Records
//        a.countriesInWorldLargestToSmallest();
//        a.countriesInContinentLargestToSmallest("'Asia'");
//        a.countriesInRegionLargestToSmallest("'Caribbean'");
//        a.TopPopulatedCountriesInWorld(5);
        a.TopPopulatedCountriesInContinent(5, "'Asia'");

        // Display all the cities in the world organised by largest population to smallest.
//        a.report5();
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


