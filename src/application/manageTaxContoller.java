
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


public class manageTaxContoller {

	// location and resources will be automatically injected by the FXML loader
		 @FXML
		 public URL location;
		 
		 @FXML
		 public Button setTaxPolicy;
		 public Button viewTaxPolicy;
		 public TextField TaxPolicy;
		 public Button back;

		 // The reference of show button will be injected by the FXML loader
		 //=new URL("D:\\SDA Spring 2022\\eclipseWorkplaceForSDA\\DemoApp\\src\\application\\SampleUI.fxml");
	     
		 @FXML
		 public ResourceBundle resources;

		// Add a public no-args constructor
		 public manageTaxContoller()
		 {
		 }
		 @FXML
		 public void initialize()
		 {
		 }
		 @FXML
		 Main main=new Main();
		 @FXML
		 public void setPolicy(ActionEvent event) throws IOException {
			 int tax=Integer.parseInt(this.TaxPolicy.getText());
			 PMS.getPms().tax.setTaxPercentage(tax);
			 String path="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\manageTax.fxml";
		        //  the stage can be accessed using action event source
				Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
				//call func inside main class to change the scene
				main.changeScene(s,path);
		 }
		 public void viewPolicy(ActionEvent event) throws IOException {
			 String tax=String.valueOf(PMS.getPms().tax.getTaxPercentage());
			this.TaxPolicy.setText(tax);
			
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
