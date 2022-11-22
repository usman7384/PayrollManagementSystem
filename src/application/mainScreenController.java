package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class mainScreenController {
	// location and resources will be automatically injected by the FXML loader
	 @FXML
	 public URL location;
	 
	 @FXML
	 
	 
	 public Button loginAsEmployee;
	 public Button loginAsHRManager;
	 public Button loginAsAccountManager;
	 
	 // The reference of show button will be injected by the FXML loader
	 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
  
	 @FXML
	 public ResourceBundle resources;

	// Add a public no-args constructor
	 public mainScreenController()
	 {
	 }
	 @FXML
	 public void initialize()
	 {
	 }
	 @FXML
	 Main main=new Main();
	 @FXML
	 public void gotoLoginEmployee(ActionEvent event) throws IOException {
		//System.out.println("this is text");
		 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\Login.fxml";
     //  the stage can be accessed using action event source
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		//call func inside main class to change the scene
		main.changeScene(s,path);
	 }
	 @FXML
	 public void gotoLoginAccountManager(ActionEvent event) throws IOException {
		//System.out.println("this is text");
		 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\loginAccountmanager.fxml";
     //  the stage can be accessed using action event source
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		//call func inside main class to change the scene
		main.changeScene(s,path);
	 }
	 @FXML
	 public void gotoLoginHRManager(ActionEvent event) throws IOException {
		//System.out.println("this is text");
		 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\LoginHRmanager.fxml";
     //  the stage can be accessed using action event source
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		//call func inside main class to change the scene
		main.changeScene(s,path);
	 }
}
