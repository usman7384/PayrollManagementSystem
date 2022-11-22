package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.PMS;
import Entities.Leave;
import Entities.Transaction;
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
import javafx.stage.Stage;

public class managePayrollJournalController {

	
	// location and resources will be automatically injected by the FXML loader
			 @FXML
			 public URL location;
			 
			 @FXML
			 
			 
			 public Button view;
			 public TextField profit;
			 public TextField loss;
			 public TableView<Transaction> table;
			 public Button back;

			 // The reference of show button will be injected by the FXML loader
			 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
		    
			 @FXML
			 public ResourceBundle resources;

			// Add a public no-args constructor
			 public managePayrollJournalController()
			 {
			 }
			 @FXML
			 public void initialize()
			 {
			 }
			 @FXML
			 Main main=new Main();
			 @FXML
			 public void viewPayroll(ActionEvent event) throws IOException {
				 PMS.getPms().managePayroll();
				 
					ArrayList <Transaction> transacts = PMS.getPms().PJ.getTransactions();
					
			    	final ObservableList<Transaction> data= FXCollections.observableArrayList(transacts);
			    	
			    	TableColumn <Transaction, String> empid = new TableColumn<>("EmpID");
					TableColumn <Transaction, String> AccountNo = new TableColumn<>("AccountNo");
					TableColumn <Transaction, String> Amount = new TableColumn<>("Amount");
					TableColumn <Transaction, String> type = new TableColumn<>("Type");
					TableColumn <Transaction, String> Date = new TableColumn<>("Date");
					
					table.getColumns().addAll(empid, AccountNo, Amount, type, Date);

			    	
			    	empid.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEmpID())));
					AccountNo.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAccountNo())));
					Amount.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAmount())));
					type.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType().toString()));
					Date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTransactionDate().toString()));
					
					table.setItems(data);
					
					this.loss.setText(String.valueOf(PMS.getPms().PJ.getLoss()));
					this.profit.setText(String.valueOf(PMS.getPms().PJ.getProfit()));

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
