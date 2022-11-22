package Entities;

import java.util.Date;

public class Loan {

	private int empID;
	private int loanAmount;
	private int AccountNo;
	private String loanDate;
	private STATUS loanStatus;




	public int getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}

	public enum STATUS {
		Accepted, Rejected, Applied
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loadAmount) {
		this.loanAmount = loadAmount;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public STATUS getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(STATUS loanStatus) {
		this.loanStatus = loanStatus;
	}

	public Loan(int empID, int loanAmount) {
		this.empID = empID;
		this.loanAmount = loanAmount;
		this.loanDate = new Date().toGMTString();
		this.loanStatus = STATUS.Applied;
	}


	public void acceptLoan() {
		
				this.setLoanStatus(Entities.Loan.STATUS.Accepted);
	}

	public void rejectLoan() {
		
				this.setLoanStatus(Entities.Loan.STATUS.Rejected);

	}
	
	@Override
	public String toString() {
		return "Loan [Employee ID=" +this.empID + ",Loan Amount=" + this.loanAmount+ " ,Status="+this.getLoanStatus()+ ",Date=" + this.loanDate+" ]";
	}

}
