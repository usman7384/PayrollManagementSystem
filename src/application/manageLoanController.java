package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.PMS;
import Entities.Leave;
import Entities.Loan;
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


public class manageLoanController {

	// location and resources will be automatically injected by the FXML loader
		 @FXML
		 public URL location;
		 
		 @FXML
		 public TableView<Loan> table;
		 @FXML
		 public Button view;
		 public Button accept;
		 public Button reject;
		 public TextField empID;
		 public Button back;

		 
		 // The reference of show button will be injected by the FXML loader
		 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
	     
		 @FXML
		 public ResourceBundle resources;

		// Add a public no-args constructor
		 public manageLoanController()
		 {
		 }
		 @FXML
		 public void initialize()
		 {
		 }
		 @FXML
		 Main main=new Main();
		 @FXML
		 public void viewAll(ActionEvent event) throws IOException {
			 PMS.getPms().ll.viewAllLoans();
				ArrayList <Loan> loans = PMS.getPms().ll.getLoans();
				
		    	final ObservableList<Loan> data= FXCollections.observableArrayList(loans);
		    	
		    	TableColumn <Loan, String> empid = new TableColumn<>("EmpID");
				TableColumn <Loan, String> loanAmount = new TableColumn<>("Amount");
				TableColumn <Loan, String> AccountNo = new TableColumn<>("Account No.");
				TableColumn <Loan, String> Date = new TableColumn<>("Date");
				TableColumn <Loan, String> status = new TableColumn<>("Status");
				
				table.getColumns().addAll(empid, loanAmount, AccountNo, Date, status);

		    	
				empid.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEmpID())));
				loanAmount.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLoanAmount())));
				AccountNo.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAccountNo())));
				Date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLoanDate()));
				status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLoanStatus().toString()));
				
				table.setItems(data);	       
		 }

		 
		 public void acceptApplication(ActionEvent event) throws IOException {
			 int empID=Integer.parseInt(this.empID.getText());
			PMS.getPms().acceptLoan(empID);
			 //System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageLoan.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path);
		 }
		 
		 public void rejectApplication(ActionEvent event) throws IOException {
			 int empID=Integer.parseInt(this.empID.getText());
			PMS.getPms().rejectLoan(empID);
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageLoan.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path);
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
