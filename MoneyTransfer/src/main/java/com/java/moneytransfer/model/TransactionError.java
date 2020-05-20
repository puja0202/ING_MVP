package com.java.moneytransfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TXNERROR")
public class TransactionError {
 
	@Column(name="CODE")
	private String errorCode;
	@Column(name="MSG")
	private String errorMsg;
	@Column(name="TXNID")
	private String txnId;
	@Column(name="ERRORID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String errorId;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getErrorId() {
		return errorId;
	}
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}
	
	
	
}
