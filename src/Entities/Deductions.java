package Entities;

public class Deductions {

	private int deductedAmount;
	private int amountPerHour=100;



	public int getDeductedAmount() {
		return deductedAmount;
	}

	public void setDeductedAmount(int deductedAmount) {
		this.deductedAmount = deductedAmount;
	}

	public int getAmountPerHour() {
		return amountPerHour;
	}

	public void setAmountPerHour(int amountPerHour) {
		this.amountPerHour = amountPerHour;
	}

	public int calculateDeductions(int empID,long downTime) {
		this.deductedAmount = (int) (this.amountPerHour * downTime);
		return deductedAmount;
	}

	@Override
	public String toString() {
		return "Deduction [Deducted Salary=" + this.deductedAmount+"]";
	}
	
}
