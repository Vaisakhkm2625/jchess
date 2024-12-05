package in.linuxwith.jchess.views;

import in.linuxwith.jchess.controllers.AppController;
import in.linuxwith.jchess.models.ChessBoardState;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ChessBoardView {
	
	private final Scene scene;
	private final ChessBoardState chessBoardState;
	
	public ChessBoardView(AppController controller) {
		
		this.chessBoardState = new ChessBoardState();
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		
		drawBoard(gridPane);
		scene = new Scene(gridPane, 640,640);
	}
	
	private void drawBoard(GridPane gridPane) {
		SimpleStringProperty[][] state =  this.chessBoardState.getBoardState();
		
		
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {

				StackPane cell = new StackPane();

				Rectangle tile= new Rectangle(80,80);
				tile.setFill((r+c)%2 == 0? Color.WHITE: Color.BLUE);
				
				
				Text pieceText = new Text();
                pieceText.textProperty().bind(state[r][c]);

                cell.getChildren().addAll(tile, pieceText);
               
                int row =r;
                int col =c;

				cell.setOnMouseClicked(e -> handleCellClick(row,col));
                
                gridPane.add(cell, c, r);
			}
			
		}
		
		
	}
	
	private void handleCellClick(int row, int col) {
		this.chessBoardState.getCell(row, col).set("helo");
		
	}
	
	public Scene getScene() {
		return this.scene;
	}
	

}
