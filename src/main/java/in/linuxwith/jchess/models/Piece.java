package in.linuxwith.jchess.models;

public class Piece {
    private String type; // "Pawn", "Rook", etc.
    private String color; // "White" or "Black"
    private String icon; // FontAwesome Unicode or other representation

    public Piece(String type, String color, String icon) {
        this.type = new String(type);
        this.color = new String(color);
        this.icon = new String(icon);
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
