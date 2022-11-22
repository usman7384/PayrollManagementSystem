package Database;

import java.util.ArrayList;

import Entities.Attendance;
import Entities.Department;
import Entities.Employee;
import Entities.Leave;
import Entities.Loan;
import Entities.Salary;
import Entities.Transaction;

public interface PersistenceHandler {
	
	abstract void connectDB();

	abstract void readDepartments(ArrayList<Department> d);
	abstract void readSalaries(ArrayList<Salary> s);
	abstract void readEmployee(ArrayList<Department> d,ArrayList<Salary> s);
	abstract void readLeaves(ArrayList<Leave> d);
	abstract void readLoans(ArrayList<Loan> d);
	abstract void readAttendance(ArrayList<Attendance> d);
	abstract void readTransaction(ArrayList<Transaction> d);

	
	
	abstract void writeDepartment(ArrayList <Department> d);
	abstract void writeEmployees(ArrayList <Employee> d);
	abstract void writeSalaries(ArrayList <Salary> d);
	abstract void writeLoans(ArrayList <Loan> d);	
	abstract void writeLeaves(ArrayList <Leave> d);
	abstract void writeAttendance(ArrayList <Attendance> d);
	abstract void writeTransaction(ArrayList <Transaction> d);
	
	abstract void emptyTable(String name);

}
