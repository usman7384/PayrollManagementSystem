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


public class deleteDepartmentController {

	// location and resources will be automatically injected by the FXML loader
		 @FXML
		 public URL location;
		 
		 @FXML
		 public Button delete;
		 public TextField ID;
		 public TableView<Department> table;
		 public Button back;


		 // The reference of show button will be injected by the FXML loader
		 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
	     
		 @FXML
		 public ResourceBundle resources;

		// Add a public no-args constructor
		 public deleteDepartmentController()
		 {
		 }
		 @FXML
		 public void initialize()
		 {
				ArrayList <Department> depts =PMS.getPms().departments.getDepts() ;
		    	final ObservableList<Department> data= FXCollections.observableArrayList(depts);
		    	
		    	TableColumn <Department, String> id = new TableColumn<>("Department ID");
				TableColumn <Department, String> name = new TableColumn<>("Department Name");


				
				table.getColumns().addAll(id, name);

		    	id.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));
		    	name.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getName())));
		    	
				table.setItems(data);	
		 }
		 @FXML
		 Main main=new Main();
		 @FXML
		 public void deleteDepartment(ActionEvent event) throws IOException {
			 int id=Integer.parseInt(this.ID.getText());
			 PMS.getPms().deletedepartment(id);
			//System.out.println("this is text");
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\deleteDepartment.fxml";
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
