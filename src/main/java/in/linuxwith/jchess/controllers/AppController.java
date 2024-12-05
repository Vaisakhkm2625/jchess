package in.linuxwith.jchess.controllers;

import in.linuxwith.jchess.views.ChessBoardView;
import in.linuxwith.jchess.views.LoginView;
import javafx.stage.Stage;

public class AppController {
	
	private Stage primaryStage;
	
	public AppController (Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void showLoginView( ) {
		LoginView loginview = new LoginView(this);
		primaryStage.setScene(loginview.getScene());
		primaryStage.setTitle("login");
		primaryStage.show();
	}
	
	public void showChessboardView() {
        ChessBoardView chessboardView = new ChessBoardView(this);
        primaryStage.setScene(chessboardView.getScene());
        primaryStage.setTitle("Chessboard");
        primaryStage.show();
    }
	

}
