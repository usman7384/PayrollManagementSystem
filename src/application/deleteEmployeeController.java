package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.PMS;
import Entities.Department;
import Entities.Employee;
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
import javafx.stage.Stage;


public class deleteEmployeeController {

	// location and resources will be automatically injected by the FXML loader
		 @FXML
		 public URL location;
		 
		 @FXML
		 public Button delete;
		 public TextField ID;
		 public TableView<Employee> table;
		 public Button back;


		 // The reference of show button will be injected by the FXML loader
		 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
	     
		 @FXML
		 public ResourceBundle resources;

		// Add a public no-args constructor
		 public deleteEmployeeController()
		 {
		 }
		 @FXML
		 public void initialize()
		 {
				ArrayList <Employee> employees =new ArrayList<Employee>() ;
				
				for(Department d:PMS.getPms().departments.getDepts()) {
					for(Employee e: d.getEmployees()) {
						employees.add(e);
					}
				}
		    	final ObservableList<Employee> data= FXCollections.observableArrayList(employees);
		    	
		    	TableColumn <Employee, String> id = new TableColumn<>("Employee ID");
				TableColumn <Employee, String> name = new TableColumn<>("Name");
				TableColumn <Employee, String> address = new TableColumn<>("Address");
				TableColumn <Employee, String> phone = new TableColumn<>("Contact");
				TableColumn <Employee, String> dept = new TableColumn<>("Department");

				table.getColumns().addAll(id, name,address,phone,dept);

		    	id.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEmpID())));
		    	name.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getName())));
		      	address.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAddress())));
		      	phone.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getContact())));
		      	dept.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDeptName())));
		    	
				table.setItems(data);	
		 }
		 @FXML
		 Main main=new Main();
		 @FXML
		 public void deleteEmployee(ActionEvent event) throws IOException {
			 int id=Integer.parseInt(this.ID.getText());
			 PMS.getPms().deleteEmployee(id);
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\deleteEmployee.fxml";
	        //  the stage can be accessed using action event source
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			//call func inside main class to change the scene
			main.changeScene(s,path);
		 }


		 public void goBack(ActionEvent event) throws IOException {
				//System.out.println("this is text");
				 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageEmployee.fxml";
		        //  the stage can be accessed using action event source
				Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
				//call func inside main class to change the scene
				main.changeScene(s,path); 
			 }
}
