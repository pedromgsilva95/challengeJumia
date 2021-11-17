package com.challenge.challengeJumia.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "customersList")
public class CustomerCountry {

    @Column(name = "customerId")
    private int customerId;
    private String customerName;
    private String countryCode;
    private String countryName;
    private String phoneNumber;
    private boolean valid;

    public CustomerCountry() {
    }

    public CustomerCountry(int customerId, String customerName, String countryCode, String countryName, String phoneNumber, boolean valid) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.phoneNumber = phoneNumber;
        this.valid = valid;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerCountry)) return false;
        CustomerCountry that = (CustomerCountry) o;
        return customerId == that.customerId && valid == that.valid && Objects.equals(customerName, that.customerName) && Objects.equals(countryCode, that.countryCode) && Objects.equals(countryName, that.countryName) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, countryCode, countryName, phoneNumber, valid);
    }

    @Override
    public String toString() {
        return "CustomerCountry{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", valid=" + valid +
                '}';
    }
}
