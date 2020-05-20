package com.java.moneytransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.moneytransfer.model.Customer;
import com.java.moneytransfer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService custService;
	
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return custService.getAllCustomer();
	}
	
	@PostMapping("/customer")
	public @ResponseBody Integer saveCustomer(@RequestBody Customer cust) {
		custService.saveCustomers(cust);
		
		return cust.getUserId();
	}
	
	
}
