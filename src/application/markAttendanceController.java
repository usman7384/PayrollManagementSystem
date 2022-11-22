package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import Controller.PMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class markAttendanceController {

	// location and resources will be automatically injected by the FXML loader
		 @FXML
		 public URL location;
		 
		 @FXML
		 public Button save;
		 public TextField ID;
		 public TextField TimeIn;
		 public TextField TimeOut;
		 public Button back;

		 // The reference of show button will be injected by the FXML loader
		 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
	     
		 @FXML
		 public ResourceBundle resources;

		// Add a public no-args constructor
		 public markAttendanceController()
		 {
		 }
		 @FXML
		 public void initialize()
		 {
		 }
		 @FXML
		 Main main=new Main();
		 @FXML
		 public void markAttendance(ActionEvent event) throws IOException {
			// int id=Integer.parseInt(this.ID.getText());
			 LocalTime timeIn=LocalTime.parse(this.TimeIn.getText());
			 LocalTime timeOut=LocalTime.parse(this.TimeOut.getText());
			 PMS.getPms().markAttendance(PMS.getPms().index, timeIn, timeOut);
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\EmployeeMenu.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path);
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
