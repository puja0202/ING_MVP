package com.java.moneytransfer.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.moneytransfer.model.Transaction;
import com.java.moneytransfer.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository txnRepo;
	
	public String updateTransaction(Transaction txn) throws Exception{
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
		return updatedBal;
	}
	
	public String getBalance(Transaction txn) throws Exception{
		String balance =  txnRepo.getAccountBalance(txn.getUserId(),txn.getAccountId());
		return balance;
	}
	
	public List<Transaction> getAllTransaction(String userId, String accountId) throws Exception{
		List<Transaction> txnList = new ArrayList<Transaction>();
		txnRepo.getAllTransaction(userId,accountId).forEach(txn -> txnList.add(txn));
		return txnList;
	}
	
	
	
}
