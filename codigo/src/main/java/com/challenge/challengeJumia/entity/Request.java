package com.challenge.challengeJumia.entity;

import java.util.Objects;

public class Request {

    private Boolean valid;
    private String country;

    public Request() {
    }

    public Request(Boolean valid, String country) {
        this.valid = valid;
        this.country = country;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return valid == request.valid && Objects.equals(country, request.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valid, country);
    }

    @Override
    public String toString() {
        return "Request{" +
                "valid=" + valid +
                ", country='" + country + '\'' +
                '}';
    }
}
