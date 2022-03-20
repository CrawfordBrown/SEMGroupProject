package com.napier.sem;

/**
 * Represents an City
 */
public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private Integer surfaceArea;
    private Integer indepYear;
    private Integer population;
    private Integer lifeExpectancy;
    private Integer gnp;
    private Integer gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private Integer capital;
    private String code2;

    public Country(String code, String name, String continent, String region, Integer surfaceArea, Integer indepYear, Integer population, Integer lifeExpectancy, Integer gnp, Integer gnpOld, String localName, String governmentForm, String headOfState, Integer capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Integer surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Integer getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Integer indepYear) {
        this.indepYear = indepYear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Integer lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Integer getGnp() {
        return gnp;
    }

    public void setGnp(Integer gnp) {
        this.gnp = gnp;
    }

    public Integer getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Integer gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", indepYear=" + indepYear +
                ", population=" + population +
                ", lifeExpectancy=" + lifeExpectancy +
                ", gnp=" + gnp +
                ", gnpOld=" + gnpOld +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", capital=" + capital +
                ", code2='" + code2 + '\'' +
                '}';
    }
}


//    public void printCountries(ArrayList<Country> countries) {
//        // Check employees is not null
//        if (countries == null) {
//            System.out.println("No countries");
//            return;
//        }
//
//
//        // Print header
//        System.out.println(String.format("%-10s %-15s %-20s",
//                "Code", "Name", "Continent"));
//        // Loop over all employees in the list
//        for (Country emp : countries) {
//            if (emp == null) continue;
//            String emp_string = String.format("%-10s %-15s %-20s",
//                    emp.getCode(),
//                    emp.getName(), emp.getContinent()
//                    );
//            System.out.println(emp_string);
//        }
//    }
//
//
//    public void outputCountries(ArrayList<Country> countries, String filename) {
//        // Check employees is not null
//        if (countries == null) {
//            System.out.println("No countries");
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        // Print header
//        sb.append("| Code | Name | Continent |\r\n");
//        sb.append("| --- | --- | --- |\r\n");
//        // Loop over all employees in the list
//        for (Country count : countries) {
//            if (count == null) continue;
//            sb.append("| " + count.getCode() + " | " +
//                    count.getName() + " | " + count.getContinent() + " |" + "\r\n");
//        }
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
//            writer.write(sb.toString());
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//    public ArrayList<Country> getCountry(String code) {
//        String sql = Country.getCode(code);
//        return getCountry(sql);
//    }

