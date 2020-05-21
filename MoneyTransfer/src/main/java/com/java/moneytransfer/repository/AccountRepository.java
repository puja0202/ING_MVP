package com.java.moneytransfer.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.java.moneytransfer.model.Account;
public interface AccountRepository extends CrudRepository<Account, String>{

	@Query("select a from Account a where a.accountid=:accountId and a.userid=:userId")
	public Account getAccountInfo(String userId, String accountId) throws Exception;

	@Query("select a from Account a where a.userid=:userId")
	public List<Account> getAccountForUser(String userId) throws Exception;

}
