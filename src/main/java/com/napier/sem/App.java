package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        if (args.length < 1) {
            a.connect("localhost:33060", 30000);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // Display the Records
        ArrayList<Country> repet1 = a.report1();

        /*
        for(Country coun : repet1){
            String coun_string = coun.getCode();
            System.out.println(coun_string);
        }
        */

        // Display all the cities in the world organised by largest population to smallest.
        ArrayList<City> repet5 = a.report5();

        // Display all the cities in a continent organised by largest population to smallest.
        ArrayList<City> repet6 = a.report6("'Europe'");

        // Display all the cities in a region organised by largest population to smallest.
        ArrayList<City> repet7 = a.report7("'Middle East'");

        // Display all the cities in a country organised by largest population to smallest.
        ArrayList<City> repet8 = a.report8("'Netherlands'");

        // Display all the cities in a district organised by largest population to smallest.
        ArrayList<City> repet9 = a.report9("'Buenos Aires'");

        // Display the top N populated cities in the world where N is provided by the user.
        ArrayList<City> repet10 = a.report10(4);

        // Display the top N populated cities in a continent where N is provided by the user.
        ArrayList<City> repet11 = a.report11(4);

        // Display the top N populated cities in a region where N is provided by the user.
        ArrayList<City> repet12 = a.report12(4);

        // Display the top N populated cities in a country where N is provided by the user.

        // Display The top N populated cities in a district where N is provided by the user.

        // Display all the capital cities in the world organised by largest population to smallest.
        ArrayList<Country> reportCP1 = a.reportCapitalPopulation1(); // FILL IN ANSWER *NOTE FOR SAM*

        // Display all the capital cities in a continent organised by largest population to smallest.
        ArrayList<Country> reportCP2 = a.reportCapitalPopulation2(); // FILL IN ANSWER *NOTE FOR SAM*

        // Display all the capital cities in a region organised by largest population to smallest.
        ArrayList<Country> reportCP3 = a.reportCapitalPopulation3(); // FILL IN ANSWER *NOTE FOR SAM*

        //Display top N populated capital cities in the world where N is provided by the user.
        ArrayList<Country> reportTC1 = a.topCapital1(); // FILL IN ANSWER *NOTE FOR SAM*

        //Display top N populated capital cities in the world where N is provided by the user.
        ArrayList<Country> reportTC2 = a.topCapital2(); // FILL IN ANSWER *NOTE FOR SAM*

        //Display top N populated capital cities in the world where N is provided by the user.
        ArrayList<Country> reportTC3 = a.topCapital3(); // FILL IN ANSWER *NOTE FOR SAM*


        // Disconnect from database
        a.disconnect();
    }

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
                                + "/employees?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /*
    All the countries in the world organised by largest population to smallest
     */

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }



    /*
    All the cities in the world organised by largest population to smallest.
     */

    public ArrayList<Country> report1() {

        System.out.println("All the countries in the world organised by largest population to smallest");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql = "select * from country order by Population desc;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(sql);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> reprt1 = new ArrayList<Country>();
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
                Country countries = new Country(code, name, continent, region, surfaceArea, indepYear, population,
                        lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
                reprt1.add(countries);

            }
            // Displays the records
            return reprt1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }

    }
    /*
    All the cities in a continent organised by largest population to smallest.
     */

    public ArrayList<City> report5() {

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
            ArrayList<City> reprt5 = new ArrayList<City>();

            while (rset5.next()) {
                Integer id = rset5.getInt("id");
                String name = rset5.getString("name");
                String countryCode = rset5.getString("countryCode");
                String district = rset5.getString("district");
                Integer population = rset5.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                reprt5.add(city);
            }
            // Displays the records
            return reprt5;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /*
        All the cities in a region organised by largest population to smallest.
     */

    public ArrayList<City> report6(String cont) {

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
            ArrayList<City> reprt6 = new ArrayList<City>();

            while (rset6.next()) {
                Integer id = rset6.getInt("id");
                String name = rset6.getString("name");
                String countryCode = rset6.getString("countryCode");
                String district = rset6.getString("district");
                Integer population = rset6.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                reprt6.add(city);
            }
            // Displays the records
            return reprt6;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /*
    All the cities in a country organised by largest population to smallest.
     */

    public ArrayList<City> report7(String reg) {

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
            ArrayList<City> reprt7 = new ArrayList<City>();

            while (rset7.next()) {
                Integer id = rset7.getInt("id");
                String name = rset7.getString("name");
                String countryCode = rset7.getString("countryCode");
                String district = rset7.getString("district");
                Integer population = rset7.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                reprt7.add(city);
            }
            // Displays the records
            return reprt7;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /*
        All the cities in a district organised by largest population to smallest.
     */

    public ArrayList<City> report8(String coutry) {

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
            ArrayList<City> reprt8 = new ArrayList<City>();

            while (rset8.next()) {
                Integer id = rset8.getInt("id");
                String name = rset8.getString("name");
                String countryCode = rset8.getString("countryCode");
                String district = rset8.getString("district");
                Integer population = rset8.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                reprt8.add(city);
            }
            // Displays the records
            return reprt8;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    public ArrayList<City> report9(String dist) {

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
            ArrayList<City> reprt9 = new ArrayList<City>();

            while (rset9.next()) {
                Integer id = rset9.getInt("id");
                String name = rset9.getString("name");
                String countryCode = rset9.getString("countryCode");
                String district = rset9.getString("district");
                Integer population = rset9.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                reprt9.add(city);
            }
            // Displays the records
            return reprt9;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /*
        The top N populated cities in the world where N is provided by the user.
     */
    public ArrayList<City> report10(int num) {

        System.out.println("The top N populated cities in the world where N is provided by the user.\n\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql10 = "SELECT * \n" +
                    "FROM city\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT " + num + ";";
            // Execute SQL statement
            ResultSet rset10 = stmt.executeQuery(sql10);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> reprt10 = new ArrayList<City>();

            while (rset10.next()) {
                Integer id = rset10.getInt("id");
                String name = rset10.getString("name");
                String countryCode = rset10.getString("countryCode");
                String district = rset10.getString("district");
                Integer population = rset10.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                reprt10.add(city);
            }
            // Displays the records
            return reprt10;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
            return null;
        }

    }

    /*
    The Top N populated cities in a continent where N is provided by the user.
    */
    public ArrayList<City> report11(int num) {

        System.out.println("the top N populated cities in a continent where N is provided by the user.\n\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql11 = "SELECT * \n" +
                    "FROM city\n" +
                    "LEFT JOIN country ON city.CountryCode = country.Code\n" +
                    "WHERE country.Continent = 'Africa'\n" +
                    "ORDER BY city.Population DESC\n" +
                    "LIMIT " + num + ";";
            // Execute SQL statement
            ResultSet rset11 = stmt.executeQuery(sql11);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> reprt11 = new ArrayList<City>();

            while (rset11.next()) {
                Integer id = rset11.getInt("id");
                String name = rset11.getString("name");
                String countryCode = rset11.getString("countryCode");
                String district = rset11.getString("district");
                Integer population = rset11.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                reprt11.add(city);
            }
            // Displays the records
            return reprt11;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }

    /*
        The Top N populated cities in a region where N is provided by the user
    */
    public ArrayList<City> report12(int num) {

        System.out.println("The Top N populated cities in a region where N is provided by the user.\n\n");
        StringBuilder sb = new StringBuilder();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String sql12 = "SELECT * \n" +
                    "FROM city\n" +
                    "JOIN country ON city.CountryCode = country.Code\n" +
                    "WHERE country.Region = 'Southern and Central Asia'\n" +
                    "ORDER BY city.Population DESC\n" +
                    "LIMIT " + num + ";";

            // Execute SQL statement
            ResultSet rset12 = stmt.executeQuery(sql12);
            // Return new cities if valid.
            // Check one is returned
            ArrayList<City> reprt12 = new ArrayList<City>();

            while (rset12.next()) {
                Integer id = rset12.getInt("id");
                String name = rset12.getString("name");
                String countryCode = rset12.getString("countryCode");
                String district = rset12.getString("district");
                Integer population = rset12.getInt("population");
                City city = new City(id, name, countryCode, district, population);
                reprt12.add(city);
            }
            // Displays the records
            return reprt12;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
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

}



}
