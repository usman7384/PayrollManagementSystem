package Entities;

import java.util.ArrayList;

public class Department {

	private int id;
	private String name;
	private ArrayList<Employee> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public Department( String name) {
		this.id=(int) ((Math.random() * (9999 - 1000)) + 1000);
		this.name = name;
		this.employees = new ArrayList<Employee>();
	}

	public Department addDepartmentDetails(int id, String name) {
		Department dept = new Department( name);
		return dept;
	}

	public void saveEmployee(Employee emp) {
		this.employees.add(emp);

	}

	public void viewAllEmployees() {
		for (Employee e : this.employees) {
			e.toString();
		}
	}

	
	
	
	@Override
	public String toString() {
		return "Department [Department ID=" +this.id + ",Department Name=" + this.name+"]";
	}
	
	
}
