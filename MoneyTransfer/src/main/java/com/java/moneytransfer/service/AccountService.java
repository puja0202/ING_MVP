package com.java.moneytransfer.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.moneytransfer.model.Account;
import com.java.moneytransfer.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accRepo;

	private static final Logger LOGGER=LoggerFactory.getLogger(AccountService.class);
	
	public void saveAccount(Account acc) throws Exception {
		LOGGER.info("Entered save account method in service class");
		accRepo.save(acc);
		LOGGER.info("Exit service method");
	}

	public Account getAccountInfo(String userId, String accountId) throws Exception{
		LOGGER.info("Entered service class method getAccountInfo");
		return accRepo.getAccountInfo(userId,accountId);
	}

	public List<Account> getAllAccounts( String userId) throws Exception{
		LOGGER.info("Entered service class method getAllAccounts");
		List<Account> accList = new ArrayList<Account>();
		accRepo.getAccountForUser(userId).forEach(acc -> accList.add(acc));
		LOGGER.info("Exit service method");
		return accList;
	}
}
