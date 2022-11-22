package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.PMS;
import Entities.Department;
import Entities.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class addEmployeeController {

	// location and resources will be automatically injected by the FXML loader
		 @FXML
		 public URL location;
		 
		 @FXML
		 public TextField ID; 
		 public TextField Name;
		 public TextField phoneno;
		 public TextField address;
		 public TextField department;
		 public ComboBox<String> selectDept;
		 public TextField accountno;
		 public TextField salary;
		 public TextField username;
		 public TextField password;
		 public TextField CNIC;
		 public Button addemployee;
		 public Button updateEmployee;
		 public Button back;
		 
		 // The reference of show button will be injected by the FXML loader
		 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
	     
		 @FXML
		 public ResourceBundle resources;

		// Add a public no-args constructor
		 public addEmployeeController()
		 {
		 }
		 @FXML
		 public void initialize()
		 {
			 ArrayList<String> depts=new ArrayList<String>();
			 for(int i=0;i< PMS.getPms().departments.getDepts().size();i++) {
				 depts.add(PMS.getPms().departments.getDepts().get(i).getName());
			 }					 
			  ObservableList<String> data = FXCollections.observableArrayList(depts);

			  selectDept.setValue("Department");
			  selectDept.setItems(data);

		 }
		 @FXML
		 Main main=new Main();
		 @FXML
		 public void addEmployee(ActionEvent event) throws IOException {
			 //int id=Integer.parseInt(this.ID.getText());
			 long accountNo=Long.parseLong(this.accountno.getText());
			 int salary=Integer.parseInt( this.salary.getText());
			 PMS.getPms().addNewEmployee( this.Name.getText(),this.address.getText(), this.phoneno.getText(), this.CNIC.getText(), this.selectDept.getValue().toString(),accountNo, this.username.getText(), this.password.getText(),salary);
			 PMS.getPms().viewAllEmployees();
			 PMS.getPms().viewAllDepartments();
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\addEmployee.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path);
		 }

		 public void upDateEmployee(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 int id=Integer.parseInt(this.ID.getText());
			 for(Department d:PMS.getPms().departments.getDepts()) {
				 for(Employee e: d.getEmployees()) {
					 if(e.getEmpID()==id) {
						 long accountNo=Long.parseLong(this.accountno.getText());
						 int salary=Integer.parseInt( this.salary.getText());
						 e.setAccountNo(accountNo);
						 e.setAddress(this.address.getText());
						 e.setCNIC(this.CNIC.getText());
						 e.setContact(this.phoneno.getText());
						 e.setPassword(this.password.getText());
						 e.getSalary().setBaseSalary(salary); }
					 }
					
			 }
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\addEmployee.fxml";
		        //  the stage can be accessed using action event source
				Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
				//call func inside main class to change the scene
				main.changeScene(s,path);
}
		 

		 public void goBack(ActionEvent event) throws IOException {
				//System.out.println("this is text");
				 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageEmployee.fxml";
		        //  the stage can be accessed using action event source
				Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
				//call func inside main class to change the scene
				main.changeScene(s,path); 
			 }
}
