package Entities;

import java.util.Date;

public class Salary {

	private int empID;
	private int baseSalary;
	private long accountNO;
	private Tax tax;
	private Deductions deduction;
	private Bonus bonus;
	private double grossSalary;
	private int month;

	
	public int getId() {
		return empID;
	}

	public void setId(int id) {
		this.empID = id;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public Deductions getDeduction() {
		return deduction;
	}

	public void setDeduction(Deductions deduction) {
		this.deduction = deduction;
	}

	public Bonus getBonus() {
		return bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(int grossSalary) {
		this.grossSalary = grossSalary;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public long getAccountNO() {
		return accountNO;
	}

	public void setAccountNO(long accountNO) {
		this.accountNO = accountNO;
	}
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Salary(int empID, int baseSalary,long accountNo) {
		this.empID = empID;
		this.baseSalary = baseSalary;
		this.bonus=new Bonus();
		this.deduction=new Deductions();
		this.tax=new Tax();
		this.accountNO=accountNo;
		this.month=new Date().getMonth();
	}

	public double calculateGrossSalary(int empID,long upTime,long downTime) {
		double taxAmount = tax.calculateTax(baseSalary);
		double bonusAmount = bonus.calculateBonus(empID,upTime);
		double deductionAmount = deduction.calculateDeductions(empID,downTime);
		this.grossSalary = this.baseSalary - taxAmount + bonusAmount - deductionAmount;
		return grossSalary;
	}
	
	
	
	@Override
	public String toString() {
		return "Salary [Employee ID=" +this.empID + ",Base Salary=" + this.baseSalary+ " ,Bonus="+this.bonus+ ",Deduction=" + this.deduction+ ",Tax=" + this.tax+ "Gross Salary "+ this.grossSalary +" ]";
	}




}
