package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.PMS;
import Entities.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class viewEmployeeReport {
	
	// location and resources will be automatically injected by the FXML loader
	 @FXML
	 public URL location;
	 
	 @FXML
	 public Button viewReport;
	 public TextField empID;
	 public TextField dept; 
	 public TextField Name;
	 public TextField Address;
	 public TextField contact;
	 public TextField Salary;
	 public TextField bonus;
	 public Button back;

	 // The reference of show button will be injected by the FXML loader
	 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
    
	 @FXML
	 public ResourceBundle resources;

	// Add a public no-args constructor
	 public viewEmployeeReport()
	 {
	 }
	 @FXML
	 public void initialize()
	 {
	 }
	 @FXML
	 Main main=new Main();
	 @FXML
	 public void viewReport(ActionEvent event) throws IOException {
		 Employee emp=PMS.getPms().viewEmployeeReport(PMS.getPms().index);
		 String id=String.valueOf(emp.getEmpID());
		 this.empID.setText(id);
		 this.dept.setText(emp.getDeptName());
		 this.Name.setText(emp.getName());
		 this.contact.setText(String.valueOf(emp.getContact()));
		 this.Address.setText(String.valueOf(emp.getAddress()));
		 this.Salary.setText(String.valueOf(emp.getSalary().getGrossSalary()));
		 this.bonus.setText(String.valueOf(emp.getSalary().getBonus().getBonusAmount()));
//		 
//		//System.out.println("this is text");
//		 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\deleteDepartment.fxml";
//       //  the stage can be accessed using action event source
//		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
//		//call func inside main class to change the scene
//		main.changeScene(s,path);
	 }
	 
	 public void goBack(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\EmployeeMenu.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path); 
		 }
}
