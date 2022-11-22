package Entities;

public class Bonus {

	private int bonusAmount;
	private int amountPerHour=100;



	public int getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(int bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public int getAmountPerHour() {
		return amountPerHour;
	}

	public void setAmountPerHour(int amountPerHour) {
		this.amountPerHour = amountPerHour;
	}

	public int calculateBonus(int empID,long upTime) {
		this.bonusAmount = (int) (this.amountPerHour * upTime);
		return bonusAmount;
	}
	
	@Override
	public String toString() {
		return "Bonus [Bonus Salary=" + this.bonusAmount+"]";
	}


}
