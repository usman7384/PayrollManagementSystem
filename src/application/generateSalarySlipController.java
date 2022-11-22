package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.PMS;
import Entities.Salary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class generateSalarySlipController {

	// location and resources will be automatically injected by the FXML loader
	 @FXML
	 public URL location;
	 
	 @FXML
	 
	 public Button generateSlip;
	 public TextField EmployeeID;
	 public TextField base;
	 public TextField gross;
	 public TextField bonus;
	 public TextField deduction;
	 public TextField tax;
	 public TextField account;
	 public TextField month;

	 public Button back;

	
	 // The reference of show button will be injected by the FXML loader
	 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
    
	 @FXML
	 public ResourceBundle resources;

	// Add a public no-args constructor
	 public generateSalarySlipController()
	 {
	 }
	 @FXML
	 public void initialize()
	 {
	 }
	 @FXML
	 Main main=new Main();
	 @FXML
	 public void generateSlips(ActionEvent event) throws IOException {
		//System.out.println("this is text");
		 PMS.getPms().calculateGrossSalary(Integer.parseInt(this.EmployeeID.getText()));
		 Salary s=PMS.getPms().generateSlip(Integer.parseInt(this.EmployeeID.getText()));
		 this.bonus.setText(String.valueOf(s.getBonus().getBonusAmount()));
		 this.deduction.setText(String.valueOf(s.getDeduction().getDeductedAmount()));
		 this.base.setText(String.valueOf(s.getBaseSalary()));
		 this.gross.setText(String.valueOf(s.getGrossSalary()));
		 this.account.setText(String.valueOf(s.getAccountNO()));
		 this.month.setText(String.valueOf(s.getMonth()));
		 this.tax.setText(String.valueOf(s.getTax().getTaxAmount()));
	 }
	 

	 public void goBack(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\AccountManagerMenu.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path); 
		 }
	 
	 

}
