package in.linuxwith.jchess.models;

import javafx.beans.property.SimpleStringProperty;

public class _ChessPiece {
    private final SimpleStringProperty type;   // Type of piece (e.g., "Pawn", "Rook")
    private final SimpleStringProperty color;  // "White" or "Black"
    private final SimpleStringProperty icon;   // FontAwesome Unicode

    public _ChessPiece(String type, String color, String icon) {
        this.type = new SimpleStringProperty(type);
        this.color = new SimpleStringProperty(color);
        this.icon = new SimpleStringProperty(icon);
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public SimpleStringProperty colorProperty() {
        return color;
    }

    public SimpleStringProperty iconProperty() {
        return icon;
    }

    public String getType() {
        return type.get();
    }

    public String getColor() {
        return color.get();
    }

    public String getIcon() {
        return icon.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public void setIcon(String icon) {
        this.icon.set(icon);
    }

    @Override
    public String toString() {
        return getType() + " (" + getColor() + ")";
    }
}
