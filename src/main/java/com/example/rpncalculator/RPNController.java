package com.example.rpncalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

public class RPNController {

    private enum ShuntingYard {
        RPN,
        Shunting;
    }

    @FXML
    private TextArea input;

    @FXML
    private GridPane buttonGroup;

    @FXML
    private ToggleButton shuntingToggle;

    private final Calculator calculator = new Calculator();

    @FXML
    public void initialize() {

        shuntingToggle.setSelected(false);
        updateToggleText();

        // Find and configure all buttons within buttonGroup
        for (javafx.scene.Node node : buttonGroup.getChildren()) {
            if (node instanceof Button button) {
                if (button.getText().equals("=")) { button.setOnAction(this::calculate);
                } else if (button.getText().equals("Clear")) {button.setOnAction(this::clear);
                } else {
                    button.setOnAction(_ -> input.appendText(button.getText()));
                }
            }
        }
    }

    @FXML
    void toggleShuntingYard(ActionEvent event) {
        updateToggleText();
    }

    void updateToggleText(){
        int test  = shuntingToggle.isSelected() ? 1 : 0;
        shuntingToggle.setText(ShuntingYard.values()[test].name());
    }

    public void calculate(ActionEvent event) {

        int result = 0;

        if (!shuntingToggle.isSelected()) {result = calculator.calculate(input.getText());
        } else {result = calculator.calculateShunting(input.getText());}

        input.setText(String.valueOf(result));
    }

    public void clear(ActionEvent event) {input.clear();}

}