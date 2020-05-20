package com.java.moneytransfer.controller;



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

import com.java.moneytransfer.model.FinalResponse;
import com.java.moneytransfer.model.Transaction;

import com.java.moneytransfer.service.TransactionService;


@RestController
public class TransactionController {

	@Autowired
	TransactionService txnService;

	private static final Logger LOGGER=LoggerFactory.getLogger(TransactionController.class);

	@PostMapping("/transaction")
	public @ResponseBody FinalResponse updateTransaction(@RequestBody Transaction txn) {
		FinalResponse response = new FinalResponse();
		try {

			Double amount = Double.valueOf(txn.getAmount());
			if(txn.getTransactionType().equalsIgnoreCase("deposit")) {
				if(amount < 0.01) {
					LOGGER.info("Entered amount invalid section");
					response.setCode("101");
					response.setMessage("Amount is invalid");
				}else {
					LOGGER.info("Entered amount valid section");
					String updatedBal = txnService.updateTransaction(txn);
					LOGGER.info("updatedBal  :"+updatedBal);
					response.setCode("100");
					response.setMessage("success, updated account balance is :"+updatedBal);
				}
			}else if (txn.getTransactionType().equalsIgnoreCase("withdraw")) {
				if(amount < 0 || amount > Double.parseDouble(txnService.getBalance(txn))) {
					LOGGER.info("Entered amount invalid section");
					response.setCode("101");
					response.setMessage("Amount is invalid or greater than the existing balance that is "+txnService.getBalance(txn));
				}else {
					LOGGER.info("Entered amount valid section");
					String updatedBal = txnService.updateTransaction(txn);
					LOGGER.info("updatedBal  :"+updatedBal);
					response.setCode("100");
					response.setMessage("success, updated account balance is :"+updatedBal);
				}
			}
		}catch (Exception e) {
			LOGGER.error("Entered catch section with exception :"+e.getMessage());
			response.setCode("102");
			response.setMessage("Exception occurred :"+e.getMessage());
		}
		return response;
	}

	@GetMapping("/{userId}/{accountId}/transactions")
	public @ResponseBody List<Transaction> getAllTransaction(@PathVariable("userId") String userId, @PathVariable("accountId") String accountId) throws Exception {
		
		return txnService.getAllTransaction(userId, accountId);
	}
	
	
}
