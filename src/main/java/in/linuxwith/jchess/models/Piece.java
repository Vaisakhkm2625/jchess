package in.linuxwith.jchess.models;

import org.kordamp.ikonli.javafx.Icon;


import org.kordamp.ikonli.javafx.Icon;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;


public class Piece {
	
	private PieceType type;
	private PieceColor color;
	private String  icon;
	
	public Piece(PieceType type, PieceColor color, String icon) {
		this.type = type;
		this.color = color;
		this.icon = icon;
	}

	public PieceType getType() {
		return type;
	}

	public void setType(PieceType type) {
		this.type = type;
	}

	public PieceColor getColor() {
		return color;
	}

	public void setColor(PieceColor color) {
		this.color = color;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	
	
	
}

