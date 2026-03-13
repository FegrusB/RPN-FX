package com.example.rpncalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
                button.setOnAction(event -> {
                    input.appendText(button.getText());
                });
            }
        }
    }

}