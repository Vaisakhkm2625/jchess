module in.linuxwith.jchess {
    requires javafx.controls;
    requires javafx.fxml;
    
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    // add icon pack modules
    requires org.kordamp.ikonli.fontawesome5;

    opens in.linuxwith.jchess to javafx.fxml;
    exports in.linuxwith.jchess;
}
