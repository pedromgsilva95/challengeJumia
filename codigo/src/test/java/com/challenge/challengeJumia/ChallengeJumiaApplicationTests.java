package com.challenge.challengeJumia;

import com.challenge.challengeJumia.constants.Constants;
import com.challenge.challengeJumia.entity.Country;
import com.challenge.challengeJumia.entity.Customer;
import com.challenge.challengeJumia.entity.CustomerCountry;
import com.challenge.challengeJumia.entity.Request;
import com.challenge.challengeJumia.service.ChallengeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ChallengeJumiaApplicationTests {

	@Autowired
	private ChallengeService challengeService;

	@Test
	void contextLoads() {
	}

	@Test
	void verifyTotalNumberOfCustomers() {
		List<CustomerCountry> customers = challengeService.getAllCustomers();
		Assert.assertEquals(41,customers.size());
	}

	@Test
	void verifyNumberOfCustomersInMozambique() {
		List<Customer> customers = challengeService.readCustomersByCountryCode(Constants.MOZAMBIQUE_COUNTRY_CODE);
		Assert.assertEquals(8,customers.size());
	}

	@Test
	void verifyNumberOfCustomersInUgandaValid() {
		Country country = new Country(Constants.UGANDA_NAME, Constants.UGANDA_COUNTRY_CODE, Constants.UGANDA_PHONE_REGEX);

		Request request = new Request(true,country.getCountryCode());
		List<CustomerCountry> customers = challengeService.filterCustomers(request);
		Assert.assertEquals(3,customers.size());
	}

	@Test
	void verifyNumberOfCustomersInMoroccoNotValid() {
		Country country = new Country(Constants.MOROCCO_NAME, Constants.MOROCCO_COUNTRY_CODE, Constants.MOROCCO_PHONE_REGEX);

		Request request = new Request(false,country.getCountryCode());
		List<CustomerCountry> customers = challengeService.filterCustomers(request);
		Assert.assertEquals(3,customers.size());
	}

	@Test
	void verifyCustomersValidInCameroon() {
		Country country = new Country(Constants.CAMEROON_NAME, Constants.CAMEROON_COUNTRY_CODE, Constants.CAMEROON_PHONE_REGEX);

		Request request = new Request(true,country.getCountryCode());
		List<CustomerCountry> customers = challengeService.filterCustomers(request);

		List<CustomerCountry> customersExpected = new ArrayList<>();
		customersExpected.add(new CustomerCountry(
				31,"EMILE CHRISTIAN KOUKOU DIKANDA HONORE ","237",Constants.CAMEROON_NAME,"697151594",true));
		customersExpected.add(new CustomerCountry(
				32,"MICHAEL MICHAEL","237",Constants.CAMEROON_NAME,"677046616",true));
		customersExpected.add(new CustomerCountry(
				34,"LOUIS PARFAIT OMBES NTSO","237",Constants.CAMEROON_NAME,"673122155",true));
		customersExpected.add(new CustomerCountry(
				35,"JOSEPH FELICIEN NOMO","237",Constants.CAMEROON_NAME,"695539786",true));
		customersExpected.add(new CustomerCountry(
				38,"THOMAS WILFRIED LOMO LOMO","237",Constants.CAMEROON_NAME,"696443597",true));
		customersExpected.add(new CustomerCountry(
				39,"Dominique mekontchou","237",Constants.CAMEROON_NAME,"691816558",true));
		customersExpected.add(new CustomerCountry(
				40,"Nelson Nelson","237",Constants.CAMEROON_NAME,"699209115",true));


		Assert.assertEquals(customersExpected, customers);
	}

}
