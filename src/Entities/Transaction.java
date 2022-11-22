package Entities;

import java.util.Date;

public class Transaction {
	private int empID;
	private long accountNo;
	private double Amount;
	private Type type;
	private String TransactionDate;


	public enum Type {
		Incoming, Outgoing,
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	public String getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}
	
	public Transaction(int empID, long accountNo, double amount, Type type) {
		this.empID = empID;
		this.accountNo = accountNo;
		this.Amount = amount;
		this.type = type;
		this.TransactionDate=new Date().toGMTString();
	}


	
	@Override
	public String toString() {
		return "Transaction [Employee ID=" +this.empID + ",Account No.=" + this.accountNo+ " ,Amount="+this.Amount+ ",Type=" + this.getType()+" ]";
	}



}
