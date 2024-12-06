package in.linuxwith.jchess.controllers;

import in.linuxwith.jchess.models.ChessBoardState;
import in.linuxwith.jchess.models.ChessCell;
import in.linuxwith.jchess.views.ChessBoardView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChessBoardController {
	
	
	private final ChessBoardState chessBoardState;
	private final ChessValidMoveHighlightManager chessValidMoveHighlightManager;  
	
	private int selectedRow = -1;
	private int selectedCol = -1;
	
	public ChessBoardController(Stage stage) {
		
		this.chessBoardState = new ChessBoardState();
		this.chessValidMoveHighlightManager = new ChessValidMoveHighlightManager(chessBoardState);
		showChessboardView(stage);
		
	}
	
	public void showChessboardView(Stage stage) {
        ChessBoardView chessboardView = new ChessBoardView(this,chessBoardState,stage);

        stage.setScene(chessboardView.getScene());
        stage.setTitle("Chessboard");
        stage.show();
    }
	
	
	public void handleSelection(int row,int col) {
		
		ChessCell[][] state = this.chessBoardState.getBoardState();

		if (selectedRow == -1 && selectedCol == -1) {
			if (state[row][col].getPiece() != null) {
				selectedRow = row;
				selectedCol = col;
				state[row][col].backgroundColorProperty().set(Color.LIGHTBLUE);
				chessValidMoveHighlightManager.markValidMoves(state[row][col].getPiece(), row, col);;

			}
		} else {
			// if (validMoves.contains(new Pair<>(row, col))) {
			state[row][col].setPiece(state[selectedRow][selectedCol].getPiece());

			state[selectedRow][selectedCol].setPiece(null);
			// }
			selectedRow = -1;
			selectedCol = -1; // Reset selection
			
			//chessBoardState.resetDefaultColors(state);
			this.chessBoardState.setDefaultColors();

		}
		
	}
	
	
	
	
	
	

}
