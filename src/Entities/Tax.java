package Entities;

public class Tax {

	private static double taxPercentage = 0.17;
	private double taxAmount;


	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(int taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		Tax.taxPercentage = taxPercentage;
	}

	public double calculateTax(double Salary) {
		this.taxAmount=this.taxPercentage*Salary;
		return taxAmount;
	}
	
	
	@Override
	public String toString() {
		return "Tax [Tax=" + this.taxAmount +"]";
	}
}
