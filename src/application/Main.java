package application;
	
import java.io.FileInputStream;
import java.io.IOException;

import Controller.PMS;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@FXML
	FXMLLoader loader=new FXMLLoader();
	@Override
	public void start(Stage primaryStage) {
		try {
			//
			String fxmldocpath="C:\\Users\\mu393\\eclipse-workspace\\PayrollManagementSystem\\src\\application\\mainScreen.fxml";
			FileInputStream fxmlStream=new FileInputStream(fxmldocpath);
			AnchorPane root = (AnchorPane)loader.load(fxmlStream);
			Scene scene = new Scene(root,800,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PMS.getPms().Read();
		launch(args);
		PMS.getPms().write();
	}
	
	public void changeScene(Stage currentStage, String path) throws IOException {
		String fxmlDocPath = path;
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane pane = (AnchorPane) loader.load(fxmlStream);
		Scene scene = new Scene(pane,944,698);
		currentStage.setScene(scene);
		currentStage.show();
		
	}
}
