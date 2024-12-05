package in.linuxwith.jchess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import in.linuxwith.jchess.controllers.AppController;

/**
 * JavaFX App
 */
public class App extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		
		AppController controller = new AppController(primaryStage);
		controller.showLoginView();
	}
	

	/*
	 @Override
	    public void start(Stage primaryStage) {

	        Button button = new Button();

	        button.setText("Click me!");

	        button.setOnAction((event) -> {
	            System.out.println("Button clicked!");
	        });


	        VBox vbox = new VBox(button);
	        Scene scene = new Scene(vbox);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	
	*/
	
	
	public static void main(String args[]) {
		launch(args);
	}
}