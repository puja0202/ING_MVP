package com.java.moneytransfer.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.moneytransfer.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
