package com.challenge.challengeJumia.controller;

import com.challenge.challengeJumia.entity.Customer;
import com.challenge.challengeJumia.entity.CustomerCountry;
import com.challenge.challengeJumia.entity.Request;
import com.challenge.challengeJumia.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    //get list of customers
    @GetMapping("/")
    public String viewHomePage(Model model){
       // model.addAttribute("listOfCustomers", challengeService.getAllCustomers());
        model.addAttribute("listOfCustomers", challengeService.getAllCustomers());
        model.addAttribute("listOfCountries", challengeService.getCountries());

        return "index";
    }

    @PostMapping("/filterCustomers")
    public String filterCustomers(@ModelAttribute("request") Request request, Model model){
        model.addAttribute("listOfCustomers",  challengeService.filterCustomers(request));
        model.addAttribute("listOfCountries", challengeService.getCountries());

        return "index";
    }

    @GetMapping("/getCustomers")
    public List<CustomerCountry> getAllCustomers() {
        return challengeService.getAllCustomers();
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return challengeService.saveCustomer(customer);
    }

}

