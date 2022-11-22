package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class HRManagerMenuController {
	
	Main m=new Main();
	@FXML
	 public Button manageEmployee;
	@FXML
	 public Button manageDepartment;
	@FXML
	 public Button manageLeave;
	@FXML
	 public Button ViewEmployeeReport;
	 public Button back;

	 
	// location and resources will be automatically injected by the FXML loader
	 @FXML
	 public URL location;
	 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
   
	 @FXML
	 public ResourceBundle resources;

	// Add a public no-args constructor
	 public HRManagerMenuController()
	 {
	 }
	 @FXML
	 public void initialize()
	 {
	 }
	 @FXML
	 public void gotoManageEmployee(ActionEvent event) throws IOException {
		//System.out.println("this is text");
		 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageEmployee.fxml";
      //  the stage can be accessed using action event source
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		//call func inside main class to change the scene
		m.changeScene(s,path);
		
		 
	 }
	 @FXML
	 public void gotoManageDepartment(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageDepartment.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
			
			 
		 }
	 @FXML
	 public void gotoManageLeave(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageLeave.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
			
			 
		 }
	 @FXML
	 public void gotoviewEmployeeReport(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\viewEmployeeReport.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
		 }
	 

	 public void goBack(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\LoginHRmanager.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path); 
		 }
	 
	 

}
