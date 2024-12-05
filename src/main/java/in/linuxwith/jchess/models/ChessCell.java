package in.linuxwith.jchess.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class ChessCell {
    
	private final SimpleStringProperty pieceType; // "Pawn", "Rook", etc.
	private final SimpleStringProperty pieceColor; // "White" or "Black"
	private final SimpleStringProperty pieceIcon; // FontAwesome Unicode or other representation

    public ChessCell(Piece piece) {
		this.pieceType = new SimpleStringProperty(piece.getType());
		this.pieceColor = new SimpleStringProperty(piece.getColor());
		this.pieceIcon = new SimpleStringProperty(piece.getIcon());
    }
    
    
    public ChessCell() {
		this.pieceType = new SimpleStringProperty();
		this.pieceColor = new SimpleStringProperty();
		this.pieceIcon = new SimpleStringProperty();

    }
    
    public SimpleStringProperty pieceTypeProperty() {
        return this.pieceType;
    }

    public SimpleStringProperty pieceColorProperty() {
        return this.pieceColor;
    }

    public SimpleStringProperty pieceIconProperty() {
        return this.pieceIcon;
    }
    
    	
    public void setPiece(Piece piece) {
		this.pieceType.set(piece.getType());
		this.pieceColor.set(piece.getColor());
		this.pieceIcon.set(piece.getIcon());
    }
    
    
    //TODO: should i return a copy?
    public Piece getPiece() {
		return new Piece(this.pieceType.get(), this.pieceColor.get(), this.pieceIcon.get());
    }
    

    public String getType() {
        return this.pieceType.get();
    }

    public String getColor() {
        return this.pieceColor.get();
    }

    public String getIcon() {
        return this.pieceIcon.get();
    }

    public void setType(String type) {
        this.pieceType.set(type);
    }

    public void setColor(String color) {
        this.pieceColor.set(color);
    }

    public void setIcon(String icon) {
        this.pieceIcon.set(icon);
    }


	@Override
	public String toString() {
		return "ChessCell [pieceType=" + this.pieceType.get() + ", pieceColor=" + this.pieceColor.get() + ", pieceIcon=" + this.pieceIcon.get() + "]";
	}
    
    
}
