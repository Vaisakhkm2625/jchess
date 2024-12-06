package in.linuxwith.jchess.views;

import in.linuxwith.jchess.controllers.AppController;
import in.linuxwith.jchess.controllers.ChessBoardController;
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
import javafx.stage.Stage;

//import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.fontawesome5.FontAwesomeRegular;

public class ChessBoardView {

	private final Scene scene;
	private final ChessBoardState chessBoardState;
	private final ChessBoardController controller;

	private int selectedRow = -1;
	private int selectedCol = -1;

	private static final int ICON_SIZE = 30;

	public ChessBoardView(ChessBoardController controller,ChessBoardState chessBoardState,Stage stage) {

		//this.chessBoardState = new ChessBoardState();
		this.chessBoardState = chessBoardState;
		this.controller = controller;

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);

		drawBoard(gridPane);
		scene = new Scene(gridPane, 640, 640);
	}

	private void drawBoard(GridPane gridPane) {
		ChessCell[][] state = chessBoardState.getBoardState();

		for (int row = 0; row < state.length; row++) {
			for (int col = 0; col < state[row].length; col++) {

				StackPane cell = new StackPane();

				Rectangle tile = new Rectangle(80, 80);

				
				tile.fillProperty().bind(state[row][col].backgroundColorProperty());
				

				// Text pieceText = new Text();
				// pieceText.setStyle("-fx-font-family: 'FontAwesome'; -fx-font-size: 36px;");

				// Text pieceText = new FontIcon();
				FontIcon pieceText = new FontIcon();
				pieceText.setIconSize(ICON_SIZE);

				pieceText.textProperty()
						.set(state[row][col].getPiece() != null ? state[row][col].getPiece().getIcon() : "");

				state[row][col].pieceProperty().addListener((observable, oldValue, newValue) -> {
					if (newValue != null) {
						pieceText.textProperty().set(newValue.getIcon());
					} else {
						pieceText.textProperty().set("");
					}
				});
				
				

				cell.getChildren().addAll(tile, pieceText);

				int currentRow = row;
				int currentCol = col;

				// Handle click events
				cell.setOnMouseClicked(event -> handleCellClick(currentRow, currentCol));

				gridPane.add(cell, col, row);

				// if (state[row][col] != null) {
				// pieceText.iconCodeProperty().bind(state[row][col].pieceIconProperty());
				// pieceText.iconCodeProperty().bind()
				// pieceText.iconCodeProperty().bind(.map(name -> Material.valueOf(name)));
				// }

			}
		}
	}
	
	

	//TODO: Sep this to a controller
	//TODO: function to handle resetting of color
	private void handleCellClick(int row, int col) {
		this.controller.handleSelection(row,col);
	}
	
	public Scene getScene() {
		return this.scene;
	}

}
