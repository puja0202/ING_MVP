package com.java.moneytransfer.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.java.moneytransfer.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, String> {

	@Transactional
	@Modifying
	@Query("update Account t set t.balance = :bal where t.accountid = :accountId")
	public void updateAccount(String bal, String accountId) throws Exception;

	@Query("select a.balance from Account a where a.userid=:userId")
	public int getBalance(String userId) throws Exception;

	@Query("select t from Transaction t where t.userId=:userId and t.accountId=:accountId")
	public List<Transaction> getAllTransaction(String userId, String accountId);

	
	@Transactional
	public default void saveTransaction(Transaction txn) {
		save(txn);
	}

	@Query("select t.txnId from Transaction t where t.userId=:userId")
	public int getTxnId(@Param("userId") String userId) throws Exception;
	
	@Query("select a.balance from Account a where a.userid=:userId and a.accountid=:accountId")
	public String getAccountBalance(String userId, String accountId) throws Exception;

}
