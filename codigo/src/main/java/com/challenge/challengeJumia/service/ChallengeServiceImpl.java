package com.challenge.challengeJumia.service;

import com.challenge.challengeJumia.entity.Country;
import com.challenge.challengeJumia.entity.Customer;
import com.challenge.challengeJumia.entity.CustomerCountry;
import com.challenge.challengeJumia.entity.Request;
import com.challenge.challengeJumia.logic.Utils;
import com.challenge.challengeJumia.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ChallengeServiceImpl implements ChallengeService{

    @Autowired
    private ChallengeRepository challengeRepository;

    @Override
    public List<CustomerCountry> getAllCustomers() {
        return Utils.convertCustomer(challengeRepository.findAll());
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return challengeRepository.save(customer);
    }


    @Override
    public List<Country> getCountries() {
        return Utils.getCountries();
    }

    @Override
    public List<CustomerCountry> filterCustomers(Request request) {
        List<Customer> result = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        //check if select All countries
        if (request.getCountry().equals("All")){
            List<Country> countriesToFilter = Utils.getCountries();
            countriesToFilter.remove(0);

            for(Country country: countriesToFilter) {
                List<Customer> customersSearch = null;
                String countryCode = Utils.normalizeCountryCode(country.getCountryCode());
                customersSearch = challengeRepository.findAllByPhoneStartsWith(countryCode);

                //verify valid/not valid or all
                if (request.isValid() != null && request.isValid()) {
                    customersSearch = Utils.filterValidCustomers(customersSearch, country.getCountryRegex());
                } else if (request.isValid() != null && !request.isValid()) {
                    customersSearch = Utils.filterNotValidCustomers(customersSearch, country.getCountryRegex());
                }
                customers.addAll(customersSearch);
            }
        } else{
            //check specific country selected
            Country countryToFilter = Utils.getCountry(request.getCountry());

            String countryCode = Utils.normalizeCountryCode(request.getCountry());
            customers = challengeRepository.findAllByPhoneStartsWith(countryCode);

            //verify valid/not valid or all
            if(request.isValid() != null && request.isValid()) {
                customers = Utils.filterValidCustomers(customers, countryToFilter.getCountryRegex());
            } else if (request.isValid() != null && !request.isValid()){
                customers = Utils.filterNotValidCustomers(customers, countryToFilter.getCountryRegex());
            }
        }

        result = Stream.concat(result.stream(), customers.stream()).collect(Collectors.toList());

        return Utils.convertCustomer(result);
    }

    public List<Customer> readCustomersByCountryCode(String countryCode) {
        countryCode = Utils.normalizeCountryCode(countryCode);
        return challengeRepository.findAllByPhoneStartsWith(countryCode);
    }

}
