package in.linuxwith.jchess.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

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
        }
		*/
		
		for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boardState[row][col] = new ChessCell();
				boardState[row][col].backgroundColorProperty().set((row + col) % 2 == 0 ? Color.BEIGE : Color.BROWN); 
            }
        }

	    for (int i = 0; i < 8; i++) {
		    boardState[1][i].setPiece(new Piece(PieceType.PAWN, PieceColor.BLACK, "♟"));
		    boardState[6][i].setPiece(new Piece(PieceType.PAWN, PieceColor.WHITE, "♙"));
		}
		boardState[0][0].setPiece(new Piece(PieceType.ROOK,   PieceColor.BLACK, "♜")); 
		boardState[0][7].setPiece(new Piece(PieceType.ROOK,   PieceColor.BLACK, "♜")); 
		boardState[7][0].setPiece(new Piece(PieceType.ROOK,   PieceColor.WHITE, "♖")); 
		boardState[7][7].setPiece(new Piece(PieceType.ROOK,   PieceColor.WHITE, "♖")); 
		boardState[0][1].setPiece(new Piece(PieceType.KNIGHT, PieceColor.BLACK, "♞")); 
		boardState[0][6].setPiece(new Piece(PieceType.KNIGHT, PieceColor.BLACK, "♞")); 
		boardState[7][1].setPiece(new Piece(PieceType.KNIGHT, PieceColor.WHITE, "♘")); 
		boardState[7][6].setPiece(new Piece(PieceType.KNIGHT, PieceColor.WHITE, "♘")); 
		boardState[0][2].setPiece(new Piece(PieceType.BISHOP, PieceColor.BLACK, "♝")); 
		boardState[0][5].setPiece(new Piece(PieceType.BISHOP, PieceColor.BLACK, "♝")); 
		boardState[7][2].setPiece(new Piece(PieceType.BISHOP, PieceColor.WHITE, "♗")); 
		boardState[7][5].setPiece(new Piece(PieceType.BISHOP, PieceColor.WHITE, "♗")); 
		boardState[0][3].setPiece(new Piece(PieceType.QUEEN,  PieceColor.BLACK, "♛")); 
		boardState[7][3].setPiece(new Piece(PieceType.QUEEN,  PieceColor.WHITE, "♕")); 
		boardState[0][4].setPiece(new Piece(PieceType.KING,   PieceColor.BLACK, "♚")); 
		boardState[7][4].setPiece(new Piece(PieceType.KING,   PieceColor.WHITE, "♔")); 

		
		//fill background colors
		
	}
	
	public void setDefaultColors() {
		for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
				this.boardState[row][col].backgroundColorProperty().set((row + col) % 2 == 0 ? Color.BEIGE : Color.BROWN); 
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
