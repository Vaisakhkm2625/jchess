package in.linuxwith.jchess.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ChessBoardState {
	
	private final ObservableList<ObservableList<SimpleStringProperty>> boardState;
	
	public ChessBoardState() {
		
		boardState = FXCollections.observableArrayList();

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
		
		for (String[] row: initialState) {
			
			ObservableList<SimpleStringProperty> observableRow = FXCollections.observableArrayList();
			
			for(String cell: row) {
				observableRow.add(new SimpleStringProperty(cell));
			}

			boardState.add(observableRow);
		}
	}

	
	public ObservableList<ObservableList<SimpleStringProperty>> getBoardState() {
		return this.boardState;
	}
}
