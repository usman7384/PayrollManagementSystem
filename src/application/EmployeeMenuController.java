package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EmployeeMenuController {
	
Main m=new Main();
@FXML
	public Button MarkAttendance;
	public Button ApplyForLoan;
	public Button ApplyForLeave;
	public Button ViewLeaveReport;
	public Button back;

	@FXML
	public URL location;
	 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
	@FXML
	 public ResourceBundle resources;

	// Add a public no-args constructor
	 public EmployeeMenuController()
	 {
	 }
	@FXML
	 public void initialize()
	 {
	 }
	@FXML
	 public void gotoMarkAttendance(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\markAttendance.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
			
			 
		 }
	@FXML
	 public void gotoApplyForLoan(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\applyForLoan.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
			
			 
		 }
	@FXML
	 public void gotoApplyForLeave(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\applyForLeave.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
			
			 
		 }
	@FXML
	 public void gotoViewLeaveReport(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\viewEmployeeReport.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path);
			
			 
		 }
	

	 public void goBack(ActionEvent event) throws IOException {
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\Login.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			m.changeScene(s,path); 
		 }
}

