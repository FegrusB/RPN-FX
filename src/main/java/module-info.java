module com.example.rpncalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.lang3;


    opens com.example.rpncalculator to javafx.fxml;
    exports com.example.rpncalculator;
}