package in.linuxwith.jchess.views;

import in.linuxwith.jchess.controllers.AppController;
import in.linuxwith.jchess.models.ChessBoardState;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
		ObservableList<ObservableList<SimpleStringProperty>> state =  this.chessBoardState.getBoardState();
		
		System.out.println(state.size());
		
		for(int r = 0; r < state.size(); r++) {
				System.out.println(state.get(r).size());
			for(int c = 0; c < state.get(r).size(); c++) {



				StackPane cell = new StackPane();

				Rectangle tile= new Rectangle(80,80);
				tile.setFill((r+c)%2 == 0? Color.WHITE: Color.BLUE);
				
				
				Text pieceText = new Text();
                pieceText.textProperty().bind(state.get(r).get(c));

                cell.getChildren().addAll(tile, pieceText);
                gridPane.add(cell, c, r);
			}
			
		}
		
		
	}
	
	public Scene getScene() {
		return this.scene;
	}
	

}
