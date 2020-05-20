package com.java.moneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.moneytransfer.model.Account;
import com.java.moneytransfer.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accRepo;
	
	public void saveAccount(Account acc) {
			accRepo.save(acc);
	}
	
	public Account getAccountInfo(String userId, String accountId){
		return accRepo.getAccountInfo(userId,accountId);
	}
}
