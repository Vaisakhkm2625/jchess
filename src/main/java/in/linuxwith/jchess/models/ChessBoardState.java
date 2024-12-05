package in.linuxwith.jchess.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ChessBoardState {
	
	//private final SimpleStringProperty[][] boardState;
	private final ChessCell[][] boardState;
	
	public ChessBoardState() {
		
		boardState = new ChessCell[8][8];

		initializeBoard();
	}
	
	private void initializeBoard() {
		
		/*String[][] initialState = {
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
        }*/
		
		// Initialize pawns
		for (int i = 0; i < 8; i++) {
		    boardState[1][i] = new ChessCell(new Piece("Pawn", "Black", "♟"));
		    boardState[6][i] = new ChessCell(new Piece("Pawn", "White", "♙"));
		}

		boardState[0][0] = new ChessCell(new Piece("Rook", "Black", "♜"));
		boardState[0][7] = new ChessCell(new Piece("Rook", "Black", "♜"));
		boardState[7][0] = new ChessCell(new Piece("Rook", "White", "♖"));
		boardState[7][7] = new ChessCell(new Piece("Rook", "White", "♖"));

		boardState[0][1] = new ChessCell(new Piece("Knight", "Black", "♞"));
		boardState[0][6] = new ChessCell(new Piece("Knight", "Black", "♞"));
		boardState[7][1] = new ChessCell(new Piece("Knight", "White", "♘"));
		boardState[7][6] = new ChessCell(new Piece("Knight", "White", "♘"));

		boardState[0][2] = new ChessCell(new Piece("Bishop", "Black", "♝"));
		boardState[0][5] = new ChessCell(new Piece("Bishop", "Black", "♝"));
		boardState[7][2] = new ChessCell(new Piece("Bishop", "White", "♗"));
		boardState[7][5] = new ChessCell(new Piece("Bishop", "White", "♗"));

		boardState[0][3] = new ChessCell(new Piece("Queen", "Black", "♛"));
		boardState[7][3] = new ChessCell(new Piece("Queen", "White", "♕"));

		boardState[0][4] = new ChessCell(new Piece("King", "Black", "♚"));
		boardState[7][4] = new ChessCell(new Piece("King", "White", "♔"));

		for (int row = 2; row < 6; row++) {
		    for (int col = 0; col < 8; col++) {
		        boardState[row][col] = new ChessCell(); 
		    }
		}
		

	}

	
	public ChessCell[][] getBoardState() {
		return this.boardState;
	}
	
	 public ChessCell getCell(int row, int col) {
	        return boardState[row][col];
	}
}
