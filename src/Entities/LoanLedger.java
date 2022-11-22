package Entities;

import java.util.ArrayList;

public class LoanLedger {

	private ArrayList<Loan> loans;

	public ArrayList<Loan> getLoans() {
		return loans;
	}

	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}

	public LoanLedger() {
		this.loans = new ArrayList<Loan>();
	}

	public void addLoan(Loan loan) {
		this.loans.add(loan);
	}



	public void viewAllLoans() {
		for (Loan l : this.loans) {
			System.out.println(l.toString());
		}
	}

}
