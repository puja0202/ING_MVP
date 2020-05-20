package com.java.moneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.java.moneytransfer.model.Account;
import com.java.moneytransfer.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accService;
	
	@PostMapping("/account")
	public @ResponseBody String saveAccount(@RequestBody Account acc) {
		accService.saveAccount(acc);
		return acc.getUserid();
	}
	
	@GetMapping("/{userId}/{accountId}/balance")
	public @ResponseBody Account getAccountInformation(@PathVariable(name="userId") String userId, @PathVariable(name="accountId") String accountId) {
		return accService.getAccountInfo(userId, accountId);
	}
}
