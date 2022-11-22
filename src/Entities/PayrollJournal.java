package Entities;

import java.util.ArrayList;

import Entities.Transaction.Type;

public class PayrollJournal {

	private final double budget;
	private double revenue;
	private double profit;
	private double loss;
	
	private ArrayList<Transaction> transactions;

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public double getBudget() {
		return budget;
	}

	
	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	
	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public double getLoss() {
		return loss;
	}

	public void setLoss(double loss) {
		this.loss = loss;
	}

	public PayrollJournal() {
		this.budget=100000;
		this.revenue=0;
		this.setTransactions(new ArrayList<Transaction>());
	}

	public void addTransaction(Transaction t) {
		this.transactions.add(t);
	}

	public String displayTransaction(Transaction t) {
		int index = 0;
		for (int i = 0; i < this.transactions.size(); i++) {
			if (this.transactions.get(i) == t) {
				index = i;
			}
		}
		return this.transactions.get(index).toString();
	}

	public void viewAllTransactions() {
		for (Transaction t : this.transactions) {
			System.out.println(t.toString());
		}
	}
	
	
	public double totalRevenue() {
		
		
		for(int i=0;i<this.transactions.size();i++) {
			if(this.transactions.get(i).getType().equals(Type.Outgoing)) {
				revenue=revenue+this.transactions.get(i).getAmount();
	
			}
		}
		return this.revenue;
	}
	
	public  void calculateProfit() {
		if(this.revenue<this.budget) {
			this.profit=this.budget-this.revenue;
		}
		else {
			this.profit=0;
		}
	}

	public  void calculateLoss() {
		if(this.revenue>this.budget) {
			this.loss=this.revenue-this.budget;
		}
		else {
			this.loss=0;
		}
	}


}
