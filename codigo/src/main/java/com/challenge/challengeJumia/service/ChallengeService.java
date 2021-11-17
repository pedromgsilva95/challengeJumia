package com.challenge.challengeJumia.service;

import com.challenge.challengeJumia.entity.Country;
import com.challenge.challengeJumia.entity.Customer;
import com.challenge.challengeJumia.entity.CustomerCountry;
import com.challenge.challengeJumia.entity.Request;

import java.util.List;

public interface ChallengeService {

    public List<CustomerCountry> getAllCustomers();

    public Customer saveCustomer(Customer customer);

    public List<Country> getCountries();

    public List<CustomerCountry> filterCustomers(Request request);

    List<Customer> readCustomersByCountryCode(String countryCode);
}
