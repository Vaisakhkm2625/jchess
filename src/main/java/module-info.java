module in.linuxwith.jchess {
    requires javafx.controls;
    requires javafx.fxml;

    opens in.linuxwith.jchess to javafx.fxml;
    exports in.linuxwith.jchess;
}
