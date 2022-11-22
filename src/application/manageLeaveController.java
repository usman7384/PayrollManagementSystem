package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class manageLeaveController {

	// location and resources will be automatically injected by the FXML loader
	 @FXML
	 public URL location;
	 
	 @FXML
	 public Button viewLeaveReport;
	 @FXML
	 public Button viewLeaveApplication;
	 public Button back;

	 
	 // The reference of show button will be injected by the FXML loader
	 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
    
	 @FXML
	 public ResourceBundle resources;

	// Add a public no-args constructor
	 public manageLeaveController()
	 {
	 }
	 @FXML
	 public void initialize()
	 {
	 }
	 @FXML
	 Main main=new Main();
	 @FXML
	 public void gotoViewLeaveReport(ActionEvent event) throws IOException {
		//System.out.println("this is text");
		 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\viewLeaveReport.fxml";
       //  the stage can be accessed using action event source
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		//call func inside main class to change the scene
		main.changeScene(s,path);
	 }
	 
	 @FXML
	 public void gotoViewLeaveApplication(ActionEvent event) throws IOException {
		//System.out.println("this is text");
		 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\viewLeaveApplication.fxml";
       //  the stage can be accessed using action event source
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		//call func inside main class to change the scene
		main.changeScene(s,path);
	 }
	 
	 public void goBack(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\HRManagerMenu.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path); 
		 }
}
