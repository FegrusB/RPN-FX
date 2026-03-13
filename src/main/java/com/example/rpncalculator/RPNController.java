package com.example.rpncalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class RPNController {

    @FXML
    private TextArea input;

    @FXML
    private Button one;

    @FXML
    protected void onOneClicked(ActionEvent event) { onButtonClicked(1); }
    @FXML
    protected void onTwoClicked(ActionEvent event) { onButtonClicked(2); }
    @FXML
    protected void onThreeClicked(ActionEvent event) { onButtonClicked(3); }


    protected void onButtonClicked(int n) { input.appendText(String.valueOf(n));}

}