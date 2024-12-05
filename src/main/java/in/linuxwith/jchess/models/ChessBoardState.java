package in.linuxwith.jchess.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ChessBoardState {
	
	private final SimpleStringProperty[][] boardState;
	
	public ChessBoardState() {
		
		boardState = new SimpleStringProperty[8][8];

		initializeBoard();
	}
	
	private void initializeBoard() {
		
		String[][] initialState = {
				 {"bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR"},
	                {"bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP"},
	                {"", "", "", "", "", "", "", ""},
	                {"", "", "", "", "", "", "", ""},
	                {"", "", "", "", "", "", "", ""},
	                {"", "", "", "", "", "", "", ""},
	                {"wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP"},
	                {"wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR"}	
		};
		
		for (int row = 0; row < initialState.length; row++) {
            for (int col = 0; col < initialState[row].length; col++) {
                boardState[row][col] = new SimpleStringProperty(initialState[row][col]);
            }
        }

	}

	
	public SimpleStringProperty[][] getBoardState() {
		return this.boardState;
	}
	
	 public SimpleStringProperty getCell(int row, int col) {
	        return boardState[row][col];
	}
}
