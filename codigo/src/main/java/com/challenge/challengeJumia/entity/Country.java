package com.challenge.challengeJumia.entity;

import java.util.Objects;

public class Country {

    private String countryName;
    private String countryCode;
    private String countryRegex;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryRegex() {
        return countryRegex;
    }

    public void setCountryRegex(String countryRegex) {
        this.countryRegex = countryRegex;
    }

    public Country() {
    }

    public Country(String countryName, String countryCode, String countryRegex) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryRegex = countryRegex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equals(countryName, country.countryName) && Objects.equals(countryCode, country.countryCode) && Objects.equals(countryRegex, country.countryRegex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, countryCode, countryRegex);
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryRegex='" + countryRegex + '\'' +
                '}';
    }
}
