package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.PMS;
import Entities.Department;
import Entities.Employee;
import Entities.Loan;
import Entities.Salary;
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

public class calculateGrossSalaryController {

	// location and resources will be automatically injected by the FXML loader
		 @FXML
		 public URL location;
		 
		 @FXML
		 
		 public Button calculate;
		 public TableView<Salary> table;
		 public Button back;

		
		 // The reference of show button will be injected by the FXML loader
		 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
	    
		 @FXML
		 public ResourceBundle resources;

		// Add a public no-args constructor
		 public calculateGrossSalaryController()
		 {
		 }
		 @FXML
		 public void initialize()
		 {
		 }
		 @FXML
		 Main main=new Main();
		 @FXML
		 public void calculateGrossSalary(ActionEvent event) throws IOException {
			 
			 
				ArrayList <Salary> salaries =new ArrayList <Salary>() ;
				for(Department d : PMS.getPms().departments.getDepts()) {
					for(Employee e: d.getEmployees()) {
						long downtime=PMS.getPms().log.getTotalDownTime(e.getEmpID());
						long uptime=PMS.getPms().log.getTotalUpTime(e.getEmpID());
						e.getSalary().calculateGrossSalary(e.getEmpID(), uptime, downtime);
						salaries.add(e.getSalary());
					}
				}
				
		    	final ObservableList<Salary> data= FXCollections.observableArrayList(salaries);
		    	
		    	TableColumn <Salary, String> empid = new TableColumn<>("EmpID");
				TableColumn <Salary, String> baseSalary = new TableColumn<>("Base Salary");
				TableColumn <Salary, String> tax = new TableColumn<>("Tax");
				TableColumn <Salary, String> deduction = new TableColumn<>("Deduction");
				TableColumn <Salary, String> bonus = new TableColumn<>("Bonus");
				TableColumn <Salary, String> gross = new TableColumn<>("Gross Salary");

				
				table.getColumns().addAll(empid, baseSalary, tax, deduction, bonus,gross);

		    	
		    	empid.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));
		    	baseSalary.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBaseSalary())));
		    	tax.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTax().getTaxAmount())));
		    	deduction.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDeduction().getDeductedAmount())));
		    	bonus.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBonus().getBonusAmount())));
		    	gross.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getGrossSalary())));

				table.setItems(data);	
			 
//			//System.out.println("this is text");
//			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\deleteDepartment.fxml";
//	       //  the stage can be accessed using action event source
//			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
//			//call func inside main class to change the scene
//			main.changeScene(s,path);
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
