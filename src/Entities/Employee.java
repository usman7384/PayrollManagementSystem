package Entities;

import java.util.ArrayList;
import java.util.Random;

public class Employee  {

	private int empID;
	private String name;
	private String address;
	private String contact;
	private String CNIC;
	private String deptName;
	private long accountNo;
	private String username;
	private String password;
	private Salary salary;
	private Leave currentLeave;
	private Loan currentLoan;
	private ArrayList<Leave> leaves;
	private ArrayList<Loan> loan;
	private ArrayList<Attendance> attendanceslog;
	private ArrayList<Salary> salaries;

	
	
	public ArrayList<Leave> getLeaves() {
		return leaves;
	}
	public void setLeaves(ArrayList<Leave> leaves) {
		this.leaves = leaves;
	}
	public ArrayList<Loan> getLoan() {
		return loan;
	}
	public void setLoan(ArrayList<Loan> loan) {
		this.loan = loan;
	}
	public ArrayList<Attendance> getAttendanceslog() {
		return attendanceslog;
	}
	public void setAttendanceslog(ArrayList<Attendance> attendanceslog) {
		this.attendanceslog = attendanceslog;
	}
	public ArrayList<Salary> getSalaries() {
		return salaries;
	}
	public void setSalaries(ArrayList<Salary> salaries) {
		this.salaries = salaries;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCNIC() {
		return CNIC;
	}
	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public Leave getCurrentLeave() {
		return currentLeave;
	}
	public void setCurrentLeave(Leave currentLeave) {
		this.currentLeave = currentLeave;
	}
	public Loan getCurrentLoan() {
		return currentLoan;
	}
	public void setCurrentLoan(Loan currentLoan) {
		this.currentLoan = currentLoan;
	}
	
	public Employee( String name, String address, String contact, String cNIC, String deptName, long accountNo,
			String username, String password,Salary salary) {
		this.empID=(int) ((Math.random() * (9999 - 1000)) + 1000);
		this.name = name;
		this.address = address;
		this.contact = contact;
		CNIC = cNIC;
		this.deptName = deptName;
		this.accountNo = accountNo;
		this.username = username;
		this.password = password;
		this.salary=salary;
	}


	
	
	
	@Override
	public String toString() {
		return "Employee [Employee ID=" +this.empID + ",Employee Name=" + this.name+ " ,Address="+this.address+ ",Contact=" + this.contact+ ",CNIC=" + this.CNIC+ ",Department=" + this.deptName+ ",Account Number=" + this.accountNo+ ",Salary=" + this.salary.getBaseSalary()+"]";
	}



}
