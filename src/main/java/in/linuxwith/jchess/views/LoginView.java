package in.linuxwith.jchess.views;


import in.linuxwith.jchess.controllers.AppController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginView {
	
	private final Scene scene;
	
	public LoginView(AppController controller) {

		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);

		Label usernameLabel = new Label("Username:");
		TextField usernameField = new TextField();
		Button loginButton = new Button("Login");
		
		
        layout.getChildren().addAll(usernameLabel,usernameField,loginButton);
        
        loginButton.setOnAction(e -> {
            if (!usernameField.getText().isEmpty()) {
                controller.showGamePlayView();
            }
        });
		
		scene = new Scene(layout,400,300);
	}

	public Scene getScene() {
		return scene;
	}

}
