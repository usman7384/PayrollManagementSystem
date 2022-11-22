package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import Controller.PMS;
import Entities.Leave;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class viewLeaveApplicationsController {

	// location and resources will be automatically injected by the FXML loader
	 // The reference of show button will be injected by the FXML loader
	 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
   @FXML
   public TableView<Leave> table;
   @FXML
   public Button view;
   public Button back;
   public Button accpet;
   public Button reject;
   public TextField TF;
   

	 @FXML
	 public ResourceBundle resources;

	// Add a public no-args constructor
	 public viewLeaveApplicationsController()
	 {
	 }
	 @FXML
	 public void initialize() 
	 {
	 }
	 @FXML
	 Main main=new Main();
	 @SuppressWarnings("unchecked")
	@FXML
	 public void viewAllApplications(ActionEvent event) throws IOException {
		 PMS.getPms().LL.viewAllLeaves();
			ArrayList <Leave> leaves = PMS.getPms().LL.getLeaves();
			
	    	final ObservableList<Leave> data= FXCollections.observableArrayList(leaves);
	    	
	    	TableColumn <Leave, String> empid = new TableColumn<>("EmpID");
			TableColumn <Leave, String> days = new TableColumn<>("No. of Days");
			TableColumn <Leave, String> status = new TableColumn<>("Status");
			TableColumn <Leave, String> reason = new TableColumn<>("Reason");
			TableColumn <Leave, String> Date = new TableColumn<>("Date");
			
			table.getColumns().addAll(empid, days, reason, Date, status);

	    	
	    	empid.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEmpID())));
			days.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNoOfDays())));
			status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus().toString()));
			reason.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getReason().toString()));
			Date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
			
			table.setItems(data);
	 }
	 
	 
	 public void acceptLeave(ActionEvent event) throws IOException {
		 
		 int id=Integer.parseInt(this.TF.getText());
		 PMS.getPms().acceptLeave(id);
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\viewLeaveApplication.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path); 
		 }
	 
	 public void rejectLeave(ActionEvent event) throws IOException {
		 int id=Integer.parseInt(this.TF.getText());
		 PMS.getPms().rejectLeave(id);
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
