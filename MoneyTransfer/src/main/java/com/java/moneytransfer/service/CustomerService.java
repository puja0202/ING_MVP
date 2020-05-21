package com.java.moneytransfer.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.moneytransfer.model.Customer;
import com.java.moneytransfer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository custRepo;

	private static final Logger LOGGER=LoggerFactory.getLogger(CustomerService.class);
	
	public List<Customer> getAllCustomer() throws Exception{
		LOGGER.info("Entered service class method getAllCustomer");
		List<Customer> custList = new ArrayList<Customer>();
		custRepo.findAll().forEach(cust->custList.add(cust));
		LOGGER.info("Exit service method");
		return custList;
	}

	public void saveCustomers(Customer cust) throws Exception {
		LOGGER.info("Entered service class method saveCustomers");
		custRepo.save(cust);
		LOGGER.info("Exit service method");
	}


}
