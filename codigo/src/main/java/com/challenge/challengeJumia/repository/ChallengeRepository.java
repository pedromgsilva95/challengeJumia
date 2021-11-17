package com.challenge.challengeJumia.repository;

import com.challenge.challengeJumia.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Customer, Integer> {

    public List<Customer> findAllByPhoneStartsWith(String countryCode);

}
