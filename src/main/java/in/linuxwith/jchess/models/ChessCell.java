package in.linuxwith.jchess.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.Icon;

public class ChessCell {
    private final ObjectProperty<Piece> pieceProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> backgroundColorProperty = new SimpleObjectProperty<Color>();

    
    public ObjectProperty<Color> backgroundColorProperty() {
        return backgroundColorProperty;
    }

    public void set(Color backgroundColorProperty) {
        this.backgroundColorProperty.set(backgroundColorProperty);
    }

    public Color getBackgroundColorProperty() {
        return backgroundColorProperty.get();
    }
    
    
    public ObjectProperty<Piece> pieceProperty() {
        return pieceProperty;
    }

    public void setPiece(Piece piece) {
        pieceProperty.set(piece);
    }

    public Piece getPiece() {
        return pieceProperty.get();
    }

}