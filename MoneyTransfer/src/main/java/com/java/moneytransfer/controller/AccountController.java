package com.java.moneytransfer.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.moneytransfer.model.Account;
import com.java.moneytransfer.model.FinalResponse;
import com.java.moneytransfer.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accService;

	private static final Logger LOGGER=LoggerFactory.getLogger(AccountController.class);

	@PostMapping("/account")
	public @ResponseBody FinalResponse saveAccount(@RequestBody Account acc) {

		LOGGER.info( "Entered the method saveAccount" );
		FinalResponse response = new FinalResponse();
		try {
			accService.saveAccount(acc);
			response.setCode("000");
			response.setMessage("Created account successsfully for user id :"+acc.getUserid());
			LOGGER.info("Executed successfully");
		}catch (Exception e) {
			LOGGER.error("Entered catch section with exception :"+e.getMessage());
			response.setCode("004");
			response.setMessage("Exception occurred :"+e.getMessage());
		}
		LOGGER.info( "Exit Controller" );
		return response;
	}

	@GetMapping("/{userId}/accounts")
	public @ResponseBody FinalResponse getAccountInformation(@PathVariable(name="userId") String userId) {

		LOGGER.info("Entered method getAccountInformation");
		List<Account> accList = new ArrayList<Account>();
		FinalResponse response = new FinalResponse();

		try {
			accList= accService.getAllAccounts(userId);
			if(!accList.isEmpty() || accList.size()>0) {
				response.setCode("000");
				response.setMessage("Successfully fetched the accounts for user id "+userId);
				response.setAccounts(accList);
				LOGGER.info("Executed successfully");
			}else {
				response.setCode("002");
				response.setMessage("No records fetched for user id "+userId);
				response.setAccounts(accList);
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

	@GetMapping("/{userId}/{accountId}/balance")
	public @ResponseBody FinalResponse getAccountInformation(@PathVariable(name="userId") String userId, @PathVariable(name="accountId") String accountId) {

		LOGGER.info("Entered method getAccountInformation");
		List<Account> accList = new ArrayList<Account>();
		Account acc = new Account();
		FinalResponse response = new FinalResponse();

		try {
			acc= accService.getAccountInfo(userId, accountId);
			accList.add(acc);
			if(!accList.isEmpty() || accList.size()>0) {
				response.setCode("000");
				response.setMessage("Successfully fetched the balance for user id "+userId+" and account id "+accountId);
				response.setAccounts(accList);
				LOGGER.info("Executed successfully");
			}else {
				response.setCode("002");
				response.setMessage("No records fetched for user id "+userId+" and account id "+accountId);
				response.setAccounts(accList);
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
}
