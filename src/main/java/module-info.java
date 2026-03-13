module com.example.rpncalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rpncalculator to javafx.fxml;
    exports com.example.rpncalculator;
}