package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import Entities.Attendance;
import Entities.Department;
import Entities.Employee;
import Entities.Leave;
import Entities.Loan;
import Entities.Salary;
import Entities.Transaction;
import Entities.Transaction.Type;

public class DBHandler implements PersistenceHandler {
	Connection con = null;

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "");
			if (con == null) {
				System.out.println("DB connection failed");
			} else
				System.out.println("DB connection successful");
		} catch (Exception e) {
			System.out.println("exception: " + e);
		}

	}

	@Override
	public void readDepartments(ArrayList<Department> departments) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from departments";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Department d = new Department(rs.getString(2));
				int id = Integer.parseInt(rs.getString(1));
				d.setId(id);
				departments.add(d);

			}
			// con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
	}

	@Override
	public void readEmployee(ArrayList<Department> depts, ArrayList<Salary> salaries) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from employees";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				long accountNO = Long.parseLong(rs.getString(7));
				int id = Integer.parseInt(rs.getString(1));
				Salary sa = null;
				for (Salary e : salaries) {
					if (e.getId() == id) {
						sa = e;
					}
				}

				Employee e = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), accountNO, rs.getString(8), rs.getString(9), sa);
				e.setEmpID(id);

				for (Department d : depts) {
					if (d.getName().equalsIgnoreCase(rs.getString(6))) {
						d.getEmployees().add(e);
					}
				}
			}
			// con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}

	}

	@Override
	public void readSalaries(ArrayList<Salary> salaries) {

		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from salaries";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				int basesalary = Integer.parseInt(rs.getString(2));
				long accountNO = Long.parseLong(rs.getString(3));

				Salary e = new Salary(id, basesalary, accountNO);
				salaries.add(e);

			}
			// con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}

	}

	@Override
	public void readLeaves(ArrayList<Leave> leaves) {
		Statement stmt;

		try {
			stmt = con.createStatement();
			String sql = "Select * from leaves";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				int id = Integer.parseInt(rs.getString(1));
				int days = Integer.parseInt(rs.getString(2));
				Leave d = new Leave(id, days, rs.getString(3));

				
				//Date date = new Date(rs.getString(4));
				d.setDate(rs.getString(4));
				d.setStatus(Leave.STATUS.valueOf(rs.getString(5)));
				leaves.add(d);

			}
			// con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
	}

	@Override
	public void readLoans(ArrayList<Loan> loans) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from loans";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				int id = Integer.parseInt(rs.getString(1));
				int amount = Integer.parseInt(rs.getString(2));
				int account = Integer.parseInt(rs.getString(3));
				//System.out.println(rs.getString(4));
				//Date date = new Date(rs.getString(4));
				Loan d = new Loan(id, amount);
				d.setLoanDate(rs.getString(4));
				d.setLoanStatus(Loan.STATUS.valueOf(rs.getString(5)));
				loans.add(d);

			}
			// con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
	}

	@Override
	public void readAttendance(ArrayList<Attendance> log) {
		Statement stmt;

		try {
			stmt = con.createStatement();
			String sql = "Select * from attendance";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				int id = Integer.parseInt(rs.getString(1));
				//System.out.println(rs.getString(2));
				//Date date = new Date(rs.getString(2));
				LocalTime in = LocalTime.parse(rs.getString(3));
				LocalTime out = LocalTime.parse(rs.getString(4));
				long up = Long.parseLong(rs.getString(5));
				long down = Long.parseLong(rs.getString(6));

				Attendance d = new Attendance(id, in, out);
				d.setDate(rs.getString(2));
				log.add(d);

			}
			// con.close();
		} catch (SQLException e) {

			System.out.println("exception: " + e);
		}
	}

	@Override
	public void readTransaction(ArrayList<Transaction> ledger) {
		Statement stmt;

		try {
			stmt = con.createStatement();
			String sql = "Select * from payrollledger";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				int id = Integer.parseInt(rs.getString(1));
				long account = Long.parseLong(rs.getString(2));
				double amount = Double.parseDouble(rs.getString(3));
				Type type = Type.valueOf(rs.getString(4));
				Date date = new Date(rs.getString(5));

				Transaction d = new Transaction(id, account, amount, type);
				d.setTransactionDate(rs.getString(5));
				ledger.add(d);

			}
			// con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
	}

	@Override
	public void writeDepartment(ArrayList<Department> d) {
		this.emptyTable("departments");

		String sql = "INSERT INTO departments (DepartmentId,Name) VALUES(?, ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);

			for (int i = 0; i < d.size(); i++) {

				statement.setString(1, Integer.toString(d.get(i).getId()));
				statement.setString(2, d.get(i).getName());

				statement.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void writeSalaries(ArrayList<Salary> e) {
		this.emptyTable("salaries");

		String sql = "INSERT INTO salaries (EmployeeId,Salary,AccountNo) VALUES(?, ?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);

			for (int i = 0; i < e.size(); i++) {
				statement.setString(1, Integer.toString(e.get(i).getId()));
				statement.setString(2, Integer.toString(e.get(i).getBaseSalary()));
				statement.setString(3, Long.toString(e.get(i).getAccountNO()));

				statement.executeUpdate();
			}

		} catch (SQLException st) {
			// TODO Auto-generated catch block
			st.printStackTrace();
		}

	}

	@Override
	public void writeEmployees(ArrayList<Employee> e) {
		this.emptyTable("employees");

		String sql = "INSERT INTO employees (EmployeeId, Name, Address, Contact, Cnic, Department, AccountNo , UserName, Password, Salary) VALUES(?,?,?,?,?,?,?, ?,?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);

			for (int i = 0; i < e.size(); i++) {
				statement.setString(1, Integer.toString(e.get(i).getEmpID()));
				statement.setString(2, e.get(i).getName());
				statement.setString(3, e.get(i).getAddress());
				statement.setString(4, e.get(i).getContact());
				statement.setString(5, e.get(i).getCNIC());
				statement.setString(6, e.get(i).getDeptName());
				statement.setString(7, Long.toString(e.get(i).getAccountNo()));
				statement.setString(8, e.get(i).getUsername());
				statement.setString(9, e.get(i).getPassword());
				statement.setString(10, Integer.toString(e.get(i).getSalary().getBaseSalary()));
				statement.executeUpdate();
			}

		} catch (SQLException st) {
			// TODO Auto-generated catch block
			st.printStackTrace();
		}

	}

	@Override
	public void writeLoans(ArrayList<Loan> e) {
		this.emptyTable("loans");

		String sql = "INSERT INTO loans (EmployeeId, Amount, AccountNo, Date, Status) VALUES(?,?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);

			for (int i = 0; i < e.size(); i++) {
				statement.setString(1, Integer.toString(e.get(i).getEmpID()));
				statement.setString(2, Integer.toString(e.get(i).getLoanAmount()));
				statement.setString(3, Integer.toString(e.get(i).getAccountNo()));
				statement.setString(4, e.get(i).getLoanDate().toString());
				statement.setString(5, e.get(i).getLoanStatus().toString());
				statement.executeUpdate();
			}

		} catch (SQLException st) {
			// TODO Auto-generated catch block
			st.printStackTrace();
		}
	}

	@Override
	public void writeLeaves(ArrayList<Leave> e) {
		this.emptyTable("leaves");

		String sql = "INSERT INTO leaves (EmployeeId, Days, Reason, Date, Status) VALUES(?,?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);

			for (int i = 0; i < e.size(); i++) {
				statement.setString(1, Integer.toString(e.get(i).getEmpID()));
				statement.setString(2, Integer.toString(e.get(i).getNoOfDays()));
				statement.setString(3, e.get(i).getReason());
				statement.setString(4, e.get(i).getDate().toString());
				statement.setString(5, e.get(i).getStatus().toString());
				statement.executeUpdate();
			}

		} catch (SQLException st) {
			// TODO Auto-generated catch block
			st.printStackTrace();
		}
	}

	@Override
	public void writeAttendance(ArrayList<Attendance> e) {
		this.emptyTable("attendance");
		String sql = "INSERT INTO attendance (EmployeeId, Date, TimeIn, TimeOut, Uptime, DownTime) VALUES(?,?,?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);

			for (int i = 0; i < e.size(); i++) {
				statement.setString(1, Integer.toString(e.get(i).getId()));
				statement.setString(2, e.get(i).getDate().toString());
				statement.setString(3, e.get(i).getTimeIN().toString());
				statement.setString(4, e.get(i).getTimeOUT().toString());
				statement.setString(5, Long.toString(e.get(i).getUptime()));
				statement.setString(6, Long.toString(e.get(i).getDowntime()));

				statement.executeUpdate();
			}

		} catch (SQLException st) {
			// TODO Auto-generated catch block
			st.printStackTrace();
		}
	}

	@Override
	public void writeTransaction(ArrayList<Transaction> e) {
		String sql = "INSERT INTO payrollledger (EmployeeId, AccountNo, Amount, Type, Date) VALUES(?,?,?,?,?)";
		this.emptyTable("payrollledger");
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);

			for (int i = 0; i < e.size(); i++) {
				statement.setString(1, Integer.toString(e.get(i).getEmpID()));
				statement.setString(2, Long.toString(e.get(i).getAccountNo()));
				statement.setString(3, Double.toString(e.get(i).getAmount()));
				statement.setString(4, e.get(i).getType().toString());
				statement.setString(5, e.get(i).getTransactionDate());
				statement.executeUpdate();
			}

		} catch (SQLException st) {
			// TODO Auto-generated catch block
			st.printStackTrace();
		}
	}

	@Override
	public void emptyTable(String name) {
		String sql = "TRUNCATE " + name;
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.executeUpdate();
			//System.out.println("Successfully truncated test_table");
		} catch (SQLException st) {
			// TODO Auto-generated catch block
			st.printStackTrace();
		}

	}

}
