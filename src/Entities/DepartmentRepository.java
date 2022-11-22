package Entities;

import java.util.ArrayList;

public class DepartmentRepository {

	public ArrayList<Department> depts;

	public ArrayList<Department> getDepts() {
		return depts;
	}

	public void setDepts(ArrayList<Department> depts) {
		this.depts = depts;
	}

	public DepartmentRepository() {
		depts = new ArrayList<Department>();
	}

	public void addDepartment(Department d) {
		this.depts.add(d);
	}

	public Department searchDepartment(int id) {
		for (Department d : this.depts) {
			if (d.getId() == id) {
				return d;
			}
		}
		return null;
	}

	public void viewAllDepartments() {
		for (Department d : this.depts) {
			System.out.println(d.toString());
		}
	}

	public void viewAllEmployees() {
		for (Department d : this.depts) {
			for (Employee e : d.getEmployees()) {
				System.out.println(e.toString());
			}
		}
	}

	public void deleteDepartment(int id) {
		for (int i = 0; i < this.getDepts().size(); i++) {
			if (this.getDepts().get(i).getId() == id) {
				this.getDepts().remove(i);
			}
		}
	}

	public void deleteEmployee(int id) {
		for (int i = 0; i < this.getDepts().size(); i++) {
			for (int j = 0; j < this.getDepts().get(i).getEmployees().size(); j++) {
				if (this.getDepts().get(i).getEmployees().get(j).getEmpID() == id) {
					this.getDepts().get(i).getEmployees().remove(j);
				}
			}
		}
	}
}
