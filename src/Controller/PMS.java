package Controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import Database.DBHandler;
import Database.PersistenceHandler;
import Entities.AccountsManager;
import Entities.Admin;
import Entities.Attendance;
import Entities.AttendanceLog;
import Entities.Department;
import Entities.DepartmentRepository;
import Entities.Employee;
import Entities.HRManager;
import Entities.Leave;
import Entities.LeaveLedger;
import Entities.Loan;
import Entities.LoanLedger;
import Entities.PayrollJournal;
import Entities.Salary;
import Entities.Tax;
import Entities.Transaction;
import Entities.Transaction.Type;

//FACADE CONTROLLER
public class PMS {
	
	//Using singleton pattern
	private static PMS pms = null;
	
	public static PMS getPms(){
        if(pms == null){
        	pms = new PMS();
        }
        return pms;
    }

	
	public DepartmentRepository departments = new DepartmentRepository();
	public LeaveLedger LL = new LeaveLedger();
	public LoanLedger ll = new LoanLedger();
	public AttendanceLog log = new AttendanceLog();
	public Admin HR = new HRManager();
	public Admin AccountsManager = new AccountsManager();
	public PayrollJournal PJ=new PayrollJournal();
	public Tax tax=new Tax();
	public ArrayList<Salary> salaries=new ArrayList<Salary>();
	public ArrayList<Employee> employees=new ArrayList<Employee>();
	PersistenceHandler handler  = new DBHandler();

	//Construtor
	public PMS() {
	}
	
	
	
	//Methods
	
	//read from DB
	public void Read() {
		handler.connectDB();
		handler.readDepartments(this.departments.getDepts());
		handler.readSalaries(salaries);
		handler.readEmployee(this.departments.getDepts(),salaries);
		handler.readAttendance(log.getAttendancelog());
		handler.readLeaves(LL.getLeaves());
		handler.readLoans(ll.getLoans());
		handler.readTransaction(PJ.getTransactions());
	}
	
	//write into db
	public void write() {
		handler.connectDB();
		handler.writeDepartment(this.departments.getDepts());
		handler.writeEmployees(employees);
		handler.writeSalaries(salaries);
		handler.writeAttendance(log.getAttendancelog());
		handler.writeLeaves(LL.getLeaves());
		handler.writeLoans(ll.getLoans());
		handler.writeTransaction(PJ.getTransactions());
	}

	//manage Pyaroll
	public void managePayroll() {
		PJ.totalRevenue();
		PJ.calculateProfit();
		PJ.calculateLoss();	
	}
	
	//perform Transaction by Accounts Manager
	public void performTransaction(int empID, long accountNo, double amount, Type type) {
	Transaction T = new Transaction(empID, accountNo, amount, type);
	PJ.addTransaction(T);
}
	
	//viewAll Leaves HR Manager
	
	public void viewAllLeaves() {
		LL.viewAllLeaves();
	}

	//viewAll Departments HR Manager
	
	public void viewAllDepartments() {
		departments.viewAllDepartments();
	}

	//viewAll Employees HR Manager
	
	public void viewAllEmployees() {
		departments.viewAllEmployees();
	}
	
	//viewAll Employees in a particular Department HR Manager
	
	public void viewEmployees(int deptID) {
		for(Department d: this.departments.depts) {
			if(d.getId()==deptID) {
				d.viewAllEmployees();
			}
		}
	}
	
	//viewAll Attendances HR Manager
	
	public void viewAllAttendances() {
		log.viewAllAttendances();
	}
	
	//viewAll Transactions AM Manager
	
	public void viewAllTransactions() {
		PJ.viewAllTransactions();
	}
	
	//viewAll Loans AM
	
	public void viewAllLoans() {
		ll.viewAllLoans();
	}
	
	
	
	//generate salary slip
	
	public Salary generateSlip(int Empid) {
		Salary s=null;
		for (Department d : this.departments.depts) {
			for (Employee e : d.getEmployees()) {
				if (Empid == e.getEmpID()) {
					s=e.getSalary();
				}
			}
		}
		return s;	
	}
	
	//view EMployeeReport
	
	public Employee viewEmployeeReport(int Empid) {
		Employee emp=null;
		for (Department d : this.departments.depts) {
			for (Employee e : d.getEmployees()) {
				if (Empid == e.getEmpID()) {
					emp=e;
				}
			}
		}
		return emp;	
	}
	
	
	//delete EMployee
	
	public void deleteEmployee(int id) {
		this.departments.deleteEmployee(id);
	}
	
	//delete department
	
	public void deletedepartment(int id) {
		this.departments.deleteDepartment(id);
	}
	
	// This Method allows the employee to apply for leave
	public void applyLeave(int EmpID, int days, String reason) {
		Leave L = new Leave(EmpID, days, reason);
		LL.addLeave(L);
	}

	// This Method allows the employee to apply for loan
	public void applyLoan(int EmpID, int Amount) {
		Loan L = new Loan(EmpID, Amount);
		ll.addLoan(L);
	}

	// This Method allows the HR to acceptLeave
	public void acceptLeave(int EmpID) {
		for (Leave L : this.LL.getLeaves()) {
			if (L.getEmpID() == EmpID) {
				L.acceptLeave();
			}
		}
	}

	// This Method allows the HR to reject Leave
	public void rejectLeave(int EmpID) {
		for (Leave L : this.LL.getLeaves()) {
			if (L.getEmpID() == EmpID) {
				L.rejectLeave();
			}
		}
	}
	
	// This Method allows the AM to acceptLoan
	public void acceptLoan(int EmpID) {
		for (Loan L : this.ll.getLoans()) {
			if (L.getEmpID() == EmpID) {
				L.acceptLoan();
				Transaction T=new Transaction(L.getEmpID(),L.getAccountNo(),L.getLoanAmount(),Transaction.Type.Outgoing);
				PJ.addTransaction(T);
			}
		}
	}

	// This Method allows the AM to reject Loan
	public void rejectLoan(int EmpID) {
		for (Loan L : this.ll.getLoans()) {
			if (L.getEmpID() == EmpID) {
				L.rejectLoan();
			}
		}
	}
	
	
	// This Method allows Accounts Manager to Calculate Gross Salary
	public void calculateGrossSalary(int empID) {
		long uptime = log.getTotalUpTime(empID);
		long downtime = log.getTotalDownTime(empID);
		for (Department d : this.departments.depts) {
			for (Employee e : d.getEmployees()) {
				if (empID == e.getEmpID()) {
					System.out.println(e.getSalary().calculateGrossSalary(empID, uptime, downtime));
					System.out.println(e.getSalary().toString());
				}
			}
		}
	}

	// This Method allows employee to mark attendance
	public void markAttendance(int empID, LocalTime timeIN, LocalTime timeOut) {
		Attendance A = new Attendance(empID, timeIN, timeOut);
		this.log.addAttendance(A);
	}

	// This Method Creates a new department and adds it to repository
	public void addNewDepartment( String name) {
		Department d = new Department( name);
		this.departments.addDepartment(d);
	}

	// this method adds new employee to a department
	public void addNewEmployee( String name, String address, String contact, String cNIC, String deptName,
			long accountNo, String username, String password, int salary) {
		Salary s=null;
		Employee emp = new Employee(name, address, contact, cNIC, deptName, accountNo, username, password, s);
		emp.setSalary(new Salary(emp.getEmpID(), salary,accountNo));
		salaries.add(emp.getSalary());
		employees.add(emp);
		for (Department d : this.departments.depts) {
			if (d.getName().equalsIgnoreCase(deptName)) {
				d.saveEmployee(emp);
			}
		}
	}

	public static int index;

	// This Method Logs the Employee into the system
	public boolean EmployeeLogin(String userName, String password) {
		boolean flag = false;
		for (Department d : this.departments.depts) {
			for (Employee e : d.getEmployees()) {
				if (e.getUsername().equals(userName) && e.getPassword().equals(password)) {
					flag = true;
					index=e.getEmpID();
					return flag;
				}
			}
		}

		return flag;
	}

	// This Method Logs the HR into the system
	public boolean HRLogin(String userName, String password) {

		boolean flag = false;

		if (HR.getUsername().equals(userName) && HR.getPassword().equals(password)) {

			flag = true;
			return flag;
		}
		return flag;
	}

	// This Method Logs the accounts manager into the system
	public boolean AccountsManagerLogin(String userName, String password) {

		boolean flag = false;

		if (AccountsManager.getUsername().equals(userName) && AccountsManager.getPassword().equals(password)) {

			flag = true;
			return flag;
		}
		return flag;
	}
	
	public static void main(String args[]) {
		

	}
}


















