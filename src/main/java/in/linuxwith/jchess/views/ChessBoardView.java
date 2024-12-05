package in.linuxwith.jchess.views;

import in.linuxwith.jchess.controllers.AppController;
import in.linuxwith.jchess.models.ChessBoardState;
import in.linuxwith.jchess.models.ChessCell;
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
	
	
	private int selectedRow = -1;
    private int selectedCol = -1;

	
	public ChessBoardView(AppController controller) {
		
		this.chessBoardState = new ChessBoardState();
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		
		drawBoard(gridPane);
		scene = new Scene(gridPane, 640,640);
	}
	
	/*
	private void drawBoard(GridPane gridPane) {
		SimpleStringProperty[][] state =  this.chessBoardState.getBoardState();
		
		
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {

				StackPane cell = new StackPane();

				Rectangle tile= new Rectangle(80,80);
				tile.setFill((r+c)%2 == 0? Color.WHITE: Color.BLUE);
				
				Text pieceText = new Text();
				
				pieceText.setStyle("-fx-font-family: 'FontAwesome'; -fx-font-size: 36px;");

				i
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
		//this.chessBoardState.getCell(row, col).set("helo");

	}
	
	*/
	
	private void drawBoard(GridPane gridPane) {
	    ChessCell[][] state = chessBoardState.getBoardState();

	    for (int row = 0; row < state.length; row++) {
	        for (int col = 0; col < state[row].length; col++) {
	            StackPane cell = new StackPane();

	            Rectangle tile = new Rectangle(80, 80);
	            tile.setFill((row + col) % 2 == 0 ? Color.BEIGE : Color.BROWN);

	            Text pieceText = new Text();
	            pieceText.setStyle("-fx-font-family: 'FontAwesome'; -fx-font-size: 36px;");

	            if (state[row][col] != null) {
	                pieceText.textProperty().bind(state[row][col].pieceIconProperty());
	            }

	            cell.getChildren().addAll(tile, pieceText);

	            int currentRow = row;
	            int currentCol = col;

	            // Handle click events
	            cell.setOnMouseClicked(event -> handleCellClick(currentRow, currentCol));

	            gridPane.add(cell, col, row);
	        }
	    }
	}

	private void handleCellClick(int row, int col) {
	    ChessCell[][] state = chessBoardState.getBoardState();

	    if (selectedRow == -1 && selectedCol == -1) {
	        // Select a piece
	        if (state[row][col] != null) {
	            selectedRow = row;
	            selectedCol = col;
	            //validMoves.clear();
	            //calculateValidMoves(row, col, state[row][col]);
	            //highlightValidCells(true);
	        }
	    } else {
	        // Move the piece if the cell is a valid move
	        //if (validMoves.contains(new Pair<>(row, col))) {
	            state[row][col].setPiece(state[selectedRow][selectedCol].getPiece());
	            // Move piece to target

	            state[selectedRow][selectedCol] = null; // Clear source cell
	            for(ChessCell[] cl: state) {
					for(ChessCell c: cl) {
						System.out.println(c);
					}
	            	
	            }
	        //}
	        //highlightValidCells(false); // Clear highlights
	        //validMoves.clear();
	        selectedRow = -1;
	        selectedCol = -1; // Reset selection
	    }
	}


	
	public Scene getScene() {
		return this.scene;
	}
	

}
