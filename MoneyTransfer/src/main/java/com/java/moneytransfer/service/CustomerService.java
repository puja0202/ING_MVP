package com.java.moneytransfer.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.moneytransfer.model.Customer;
import com.java.moneytransfer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository custRepo;
	
	public List<Customer> getAllCustomer(){
		List<Customer> custList = new ArrayList<Customer>();
		custRepo.findAll().forEach(cust->custList.add(cust));
		return custList;
	}
	
	public void saveCustomers(Customer cust) {
		custRepo.save(cust);
	}
	
	
}
