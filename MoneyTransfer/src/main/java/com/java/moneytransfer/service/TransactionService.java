package com.java.moneytransfer.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.moneytransfer.model.Transaction;
import com.java.moneytransfer.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository txnRepo;

	private static final Logger LOGGER=LoggerFactory.getLogger(TransactionService.class);
	
	public String updateTransaction(Transaction txn) throws Exception{
		LOGGER.info("Entered service class method updateTransaction");
		Double newBalance = 0.0;
		String balance =  txnRepo.getAccountBalance(txn.getUserId(),txn.getAccountId());
		if(txn.getTransactionType().equalsIgnoreCase("Deposit")) {
			newBalance = Double.parseDouble(balance)+Double.parseDouble(txn.getAmount());
		}else if (txn.getTransactionType().equalsIgnoreCase("Withdraw")) {
			newBalance = Double.parseDouble(balance)-Double.parseDouble(txn.getAmount());
		}
		txnRepo.updateAccount(newBalance.toString(), txn.getAccountId());
		txnRepo.saveTransaction(txn);
		String updatedBal = txnRepo.getAccountBalance(txn.getUserId(),txn.getAccountId());
		LOGGER.info("Exit service method");
		return updatedBal;
		
	}

	public String getBalance(Transaction txn) throws Exception{
		LOGGER.info("Entered service class method getBalance");
		String balance =  txnRepo.getAccountBalance(txn.getUserId(),txn.getAccountId());
		LOGGER.info("Exit service method");
		return balance;
	}

	public List<Transaction> getAllTransaction(String userId, String accountId) throws Exception{
		LOGGER.info("Entered service class method getAllTransaction");
		List<Transaction> txnList = new ArrayList<Transaction>();
		txnRepo.getAllTransaction(userId,accountId).forEach(txn -> txnList.add(txn));
		LOGGER.info("Exit service method");
		return txnList;
		
	}



}
