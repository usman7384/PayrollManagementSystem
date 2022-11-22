package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.PMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginHRManagerController {
	// location and resources will be automatically injected by the FXML loader
			 @FXML
			 public URL location; 
			 @FXML
			 public TextField username;
			 @FXML
			 public TextField password;
			 @FXML
			 public Button login;
			 public Button back;

			 
			 // The reference of show button will be injected by the FXML loader
			 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
		   
			 @FXML
			 public ResourceBundle resources;

			// Add a public no-args constructor
			 public loginHRManagerController()
			 {
			 }
			 @FXML
			 public void initialize()
			 {
			 }
			 @FXML
			 Main main=new Main();
			 @FXML
			 public void gotoHRManager(ActionEvent event) throws IOException {
				 //System.out.println(this.username.getText()+ this.password.getText());
				 //System.out.println(PMS.getPms().HRLogin(this.username.toString(), this.password.toString()));
				if( PMS.getPms().HRLogin(this.username.getText(), this.password.getText())){
				//System.out.println("this is text");
				 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\HRManagerMenu.fxml";
		      //  the stage can be accessed using action event source
				Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
				//call func inside main class to change the scene
				main.changeScene(s,path);
			 }
			 }
			 

			 public void goBack(ActionEvent event) throws IOException {
					//System.out.println("this is text");
					 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\mainScreen.fxml";
			        //  the stage can be accessed using action event source
					Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
					//call func inside main class to change the scene
					main.changeScene(s,path); 
				 }
}
