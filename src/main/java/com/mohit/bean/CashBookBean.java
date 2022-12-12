package com.mohit.bean;

public class CashBookBean {
	private int acid;
	private String account;
	private String transaction_date;
	private double amount;
	private int userid;
	private String operation;
	
	public CashBookBean() {
	
	}

	public CashBookBean(int acid, String account, String transaction_date, double amount, int userid, String operation) {		
		this.acid = acid;
		this.account = account;
		this.transaction_date = transaction_date;
		this.amount = amount;
		this.userid = userid;
		this.operation = operation;
	}

	public int getAcid() {
		return acid;
	}

	public void setAcid(int acid) {
		this.acid = acid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String toString() {
		return "CashBookBean [acid=" + acid + ", account=" + account + ", transaction_date=" + transaction_date
				+ ", amount=" + amount + ", userid=" + userid + ", operation=" + operation + "]";
	}
	
	
}
