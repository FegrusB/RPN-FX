package com.example.rpncalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class RPNController {

    @FXML
    private TextArea input;

    @FXML
    private GridPane buttonGroup;

    @FXML
    public void initialize() {
        // Find and configure all buttons within buttonGroup
        for (javafx.scene.Node node : buttonGroup.getChildren()) {
            if (node instanceof Button button) {
                if (button.getText().equals("=")) { button.setOnAction(this::calculate);
                } else if (button.getText().equals("Clear")) {button.setOnAction(this::clear);
                } else {
                    button.setOnAction(event -> input.appendText(button.getText()));
                }
            }
        }
    }

    public void calculate(ActionEvent event) {}

    public void clear(ActionEvent event) {input.clear();}

}