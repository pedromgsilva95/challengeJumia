package com.challenge.challengeJumia.logic;

import com.challenge.challengeJumia.constants.Constants;
import com.challenge.challengeJumia.entity.Country;
import com.challenge.challengeJumia.entity.Customer;
import com.challenge.challengeJumia.entity.CustomerCountry;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Customer> filterValidCustomers(List<Customer> customers, String regex) {
        List<Customer> result = new ArrayList<>();
        for(Customer customer : customers){
            if(customer.getPhone().matches(regex)){
                result.add(customer);
            }
        }
        return result;
    }

    public static List<Customer> filterNotValidCustomers(List<Customer> customers, String regex) {
        List<Customer> result = new ArrayList<>();
        for(Customer customer : customers){
            if(!customer.getPhone().matches(regex)){
                result.add(customer);
            }
        }
        return result;
    }

    private static String extractCountryCode(String phone) {
        return phone.split("\\(")[1].split("\\)")[0].trim();
    }

    private static String extractPhoneNumber(String phone) {
        return phone.split("\\s")[1];
    }

    public static boolean validatePhoneNumber(String phoneNumber, String regex){
        if(phoneNumber.matches(regex)){
            return true;
        }
        return false;
    }

    public static List<Country> getCountries(){
        List<Country> countries = new ArrayList<>();

        Country countryAll = new Country("All", "All", "");
        countries.add(countryAll);

        Country cameroon = new Country(Constants.CAMEROON_NAME,Constants.CAMEROON_COUNTRY_CODE,Constants.CAMEROON_PHONE_REGEX);
        countries.add(cameroon);

        Country ethiopia = new Country(Constants.ETHIOPIA_NAME,Constants.ETHIOPIA_COUNTRY_CODE,Constants.ETHIOPIA_PHONE_REGEX);
        countries.add(ethiopia);

        Country morocco = new Country(Constants.MOROCCO_NAME,Constants.MOROCCO_COUNTRY_CODE,Constants.MOROCCO_PHONE_REGEX);
        countries.add(morocco);

        Country mozambique = new Country(Constants.MOZAMBIQUE_NAME,Constants.MOZAMBIQUE_COUNTRY_CODE,Constants.MOZAMBIQUE_PHONE_REGEX);
        countries.add(mozambique);

        Country uganda = new Country(Constants.UGANDA_NAME,Constants.UGANDA_COUNTRY_CODE,Constants.UGANDA_PHONE_REGEX);
        countries.add(uganda);

        return countries;
    }

    public static Country getCountry(String countryCode){
        List<Country> countries = new ArrayList<>();
        countries = Utils.getCountries();

        for(Country country: countries){
            if(country.getCountryCode().equals(countryCode)){
                return country;
            }
        }

        return null;
    }

    public static String normalizeCountryCode(String countryCode){
        if (countryCode != null && !countryCode.isEmpty()) {
            countryCode = countryCode.replaceAll("[^0-9]", "");
            return "(" + countryCode + ")";
        }
        return countryCode;
    }

    public static Country getCountryByCountryCode(List<Country> countries , String countryCode){
        if (countryCode != null && !countryCode.isEmpty()) {
            for (Country country: countries){
                if (country.getCountryCode().equals(countryCode)){
                    return country;
                }
            }
        }
        return null;
    }

    public static List<CustomerCountry> convertCustomer(List<Customer> customers){
        List<CustomerCountry> customersCountry = new ArrayList<>();
        List<Country> countries = getCountries();

        for(Customer customer : customers){
            CustomerCountry response = new CustomerCountry();
            response.setCustomerId(customer.getId());
            response.setCustomerName(customer.getName());
            response.setPhoneNumber(extractPhoneNumber(customer.getPhone()));

            String code = extractCountryCode(customer.getPhone());
            response.setCountryCode(code);

            Country country = getCountryByCountryCode(countries, code);
            if(country != null){
                response.setCountryName(country.getCountryName());
                response.setValid(customer.getPhone().matches(country.getCountryRegex()));
            }

            customersCountry.add(response);
        }
        return customersCountry;
    }

}
