package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.PMS;
import Entities.Department;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class addDepartmentController {

	



	// location and resources will be automatically injected by the FXML loader
		 @FXML
		 public URL location;
		 
		 @FXML
		 public TextField depID;
		 public TextField depName;	
		 public Button addDepartment; 	
		 public Button updateDepartment;
		 public Button back;
// The reference of show button will be injected by the FXML loader
		 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
	     
		 @FXML
		 public ResourceBundle resources;

		// Add a public no-args constructor
		 public addDepartmentController()
		 {
		 }
		 @FXML
		 public void initialize()
		 {
		 }
		 @FXML
		 Main main=new Main();
		 @FXML
		 public void addDepartment(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			// int id=Integer.parseInt(this.depID.getText());
			 PMS.getPms().addNewDepartment(this.depName.getText());
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\addDepartment.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path);
		 }
		 
		 public void upDateDepartment(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 int id=Integer.parseInt(this.depID.getText());
			 for(Department d:PMS.getPms().departments.getDepts()) {
				 if(d.getId()==id) {
					 d.setName(this.depName.getText());
				 }
			 }
			 
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\addDepartment.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path);
		 }
		 

		 public void goBack(ActionEvent event) throws IOException {
				//System.out.println("this is text");
				 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageDepartment.fxml";
		        //  the stage can be accessed using action event source
				Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
				//call func inside main class to change the scene
				main.changeScene(s,path); 
			 }
}
