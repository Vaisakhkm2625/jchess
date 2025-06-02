
package in.linuxwith.jchess.controllers;

import in.linuxwith.jchess.models.ChessBoardState;
import in.linuxwith.jchess.models.ChessCell;
import in.linuxwith.jchess.models.Piece;
import in.linuxwith.jchess.models.PieceColor;
import javafx.scene.paint.Color;

public class ChessValidMoveHighlightManager{
    private ChessCell[][] boardState;

    public ChessValidMoveHighlightManager(ChessBoardState boardState) {
        this.boardState = boardState.getBoardState();
        // Initialize boardState as required.
    }

    public void markValidMoves(Piece piece, int row, int col) {
        if (piece == null) return;

        switch (piece.getType()) {
            case PAWN:
                markPawnMoves(piece, row, col);
                break;
            case ROOK:
                markStraightMoves(piece, row, col);
                break;
            case KNIGHT:
                markKnightMoves(piece, row, col);
                break;
            case BISHOP:
                markDiagonalMoves(piece, row, col);
                break;
            case QUEEN:
                markStraightMoves(piece, row, col);
                markDiagonalMoves(piece, row, col);
                break;
            case KING:
                markKingMoves(piece, row, col);
                break;
        }
    }

    private void markPawnMoves(Piece piece, int row, int col) {
        int direction = (piece.getColor() == PieceColor.WHITE) ? -1 : 1;
        int startRow = (piece.getColor() == PieceColor.WHITE) ? 6 : 1;

        // One step forward
        if (isInBounds(row + direction, col) && boardState[row + direction][col].getPiece() == null) {
            //boardState[row + direction][col].backgroundColorProperty().set(Color.LIGHTBLUE);
			highlightCell(row + direction,col);

            // Two steps forward from start row
            if (row == startRow && boardState[row + 2 * direction][col].getPiece() == null) {
                //boardState[row + 2 * direction][col].backgroundColorProperty().set(Color.LIGHTBLUE);
                highlightCell(row + 2 * direction,col);
            }
        }

        // Capture diagonally
        if (isInBounds(row + direction, col - 1) && isOpponentPiece(piece, row + direction, col - 1)) {
				highlightCell(row + direction,col - 1);
        }
        if (isInBounds(row + direction, col + 1) && isOpponentPiece(piece, row + direction, col + 1)) {
            highlightCell(row + direction,col + 1);
        }
    }

    private void markStraightMoves(Piece piece, int row, int col) {
        markDirectionalMoves(piece, row, col, 1, 0);  // Down
        markDirectionalMoves(piece, row, col, -1, 0); // Up
        markDirectionalMoves(piece, row, col, 0, 1);  // Right
        markDirectionalMoves(piece, row, col, 0, -1); // Left
    }

    private void markDiagonalMoves(Piece piece, int row, int col) {
        markDirectionalMoves(piece, row, col, 1, 1);   // Down-right
        markDirectionalMoves(piece, row, col, 1, -1);  // Down-left
        markDirectionalMoves(piece, row, col, -1, 1);  // Up-right
        markDirectionalMoves(piece, row, col, -1, -1); // Up-left
    }

    private void markDirectionalMoves(Piece piece, int row, int col, int rowDelta, int colDelta) {
        int r = row + rowDelta, c = col + colDelta;
        while (isInBounds(r, c)) {
            if (boardState[r][c].getPiece() == null) {
                boardState[r][c].backgroundColorProperty().set(Color.LIGHTBLUE);
            } else {
                if (isOpponentPiece(piece, r, c)) {
                    //boardState[r][c].backgroundColorProperty().set(Color.LIGHTBLUE);
                    highlightCell(r,c);
                }
                break;
            }
            r += rowDelta;
            c += colDelta;
        }
    }

    private void markKnightMoves(Piece piece, int row, int col) {
        int[][] deltas = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for (int[] delta : deltas) {
            int r = row + delta[0], c = col + delta[1];
            if (isInBounds(r, c) && (boardState[r][c].getPiece() == null || isOpponentPiece(piece, r, c))) {
                //boardState[r][c].backgroundColorProperty().set(Color.LIGHTBLUE);
                highlightCell(r,c);
            }
        }
    }

    private void markKingMoves(Piece piece, int row, int col) {
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr != 0 || dc != 0) {
                    int r = row + dr, c = col + dc;
                    if (isInBounds(r, c) && (boardState[r][c].getPiece() == null || isOpponentPiece(piece, r, c))) {
                        //boardState[r][c].backgroundColorProperty().set(Color.LIGHTBLUE);
						highlightCell(r,c);
                    }
                }
            }
        }
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }


    private boolean isOpponentPiece(Piece piece, int row, int col) {
        return boardState[row][col].getPiece() != null &&
               boardState[row][col].getPiece().getColor() != piece.getColor();
    }
    
	 private void highlightCell(int row, int col) {
		    if (!isInBounds(row, col)) return;
		    Color baseColor = ((row + col) % 2 == 0) ? Color.BEIGE : Color.BROWN;
		    Color highlightColor = baseColor.interpolate(Color.LIGHTBLUE, 0.5);
		    boardState[row][col].backgroundColorProperty().set(highlightColor);
	}
    
    
}
