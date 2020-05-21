package com.java.moneytransfer.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.moneytransfer.model.Customer;
import com.java.moneytransfer.model.FinalResponse;
import com.java.moneytransfer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService custService;

	private static final Logger LOGGER=LoggerFactory.getLogger(AccountController.class);

	@GetMapping("/customers")
	public @ResponseBody FinalResponse getAllCustomers(){

		LOGGER.info("Entered method getAllCustomers");
		FinalResponse response = new FinalResponse();
		List<Customer> custList = new ArrayList<Customer>();

		try {
			custList = custService.getAllCustomer();
			if(!custList.isEmpty() || custList.size()>0) {
				response.setCode("000");
				response.setMessage("Successfully fetched the customer list");
				response.setCustomers(custList);
				LOGGER.info("Executed successfully");
			}else {
				response.setCode("002");
				response.setMessage("No records present");
				response.setCustomers(custList);
				LOGGER.info("No records present");
			}
		}catch (Exception e) {
			LOGGER.error("Entered catch section with exception :"+e.getMessage());
			response.setCode("004");
			response.setMessage("Exception occurred :"+e.getMessage());
		}
		LOGGER.info( "Exit Controller" );
		return response;
	}

	@PostMapping("/customer")
	public @ResponseBody FinalResponse saveCustomer(@RequestBody Customer cust) {

		LOGGER.info("Entered method saveCustomer");
		FinalResponse response = new FinalResponse();

		try {
			custService.saveCustomers(cust); 
			response.setCode("000");
			response.setMessage("Created customer successsfully and  user id is :"+cust.getUserId());
			LOGGER.info("Executed successfully");
		}catch (Exception e) {
			LOGGER.error("Entered catch section with exception :"+e.getMessage());
			response.setCode("004");
			response.setMessage("Exception occurred :"+e.getMessage());
		}
		LOGGER.info( "Exit Controller" );
		return response;
	}


}
