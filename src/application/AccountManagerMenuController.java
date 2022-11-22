package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AccountManagerMenuController {
	Main m=new Main();
	
	 @FXML
	 // The reference of show button will be injected by the FXML loader
	 public Button manageTax;
	 public Button manageLoan;
	 public Button managePayrolljournal;
	 public Button calculateGrosssalary;
	 public Button generateSalarySlip;
	 public Button sendSalary;
	 public Button back;

	// location and resources will be automatically injected by the FXML loader
	 @FXML
	 public URL location;
	 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
    
	 @FXML
	 public ResourceBundle resources;

	// Add a public no-args constructor
	 public AccountManagerMenuController()
	 {
	 }
	 @FXML
	 public void initialize()
	 {
	 }
	 @FXML
	 public void gotoManageTax(ActionEvent event) throws IOException {
		//System.out.println("this is text");
		 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageTax.fxml";
       //  the stage can be accessed using action event source
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		//call func inside main class to change the scene
		m.changeScene(s,path);
		
		 
	 }
	 @FXML
	 public void gotoManageLoan(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageLoan.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
			
			 
		 }
	 @FXML
	 public void gotoManagePayrollJournal(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\managePayrollJournal.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
			
			 
		 }
	 @FXML
	 public void gotoCalculateGrossSalary(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\calculateGrossSalary.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
			
			 
		 }
	 @FXML
	 public void gotoGenerateSalarySlip(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\generateSalarySlip.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
			
			 
		 }
	 @FXML
	 public void gotoSendSalary(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\Salary.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path); 
		 }

	 public void goBack(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\loginAccountmanager.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path); 
		 }
}
