package com.napier.sem;

/*
 * Represents an Country Languages
 */

public class CountryLanguage {

    private String code;
    private String language;
    private String official;
    private int percentage;

    public CountryLanguage(String code, String language, String official, int percentage){
        this.code = code;
        this.language = language;
        this.official = official;
        this.percentage = percentage;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getLanguage(){
        return language;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public String getOfficial(){
        return official;
    }

    public void setOfficial(String official){
        this.official = official;
    }

    public int getPercentage(){
        return percentage;
    }

    public void setPercentage(int percentage){
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "code='" + code + '\'' +
                ", language='" + language + '\'' +
                ", official='" + official + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
    }
}
