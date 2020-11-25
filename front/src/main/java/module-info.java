module front.end {
    requires javafx.controls;
    requires javafx.fxml;

    opens front.end to javafx.fxml;
    exports front.end;
}