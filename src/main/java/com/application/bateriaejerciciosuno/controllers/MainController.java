package com.application.bateriaejerciciosuno.controllers;

import com.application.bateriaejerciciosuno.view.RevistaFormView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    public Label nombre;
    @FXML
    public void openRevistaCreator(ActionEvent actionEvent) {
        RevistaFormView.runRevistaFormView();
    }

    public void openRevistaShow(ActionEvent actionEvent) {
    }

    public void openBoletinShow(ActionEvent actionEvent) {
    }

    public void openBoletinCreator(ActionEvent actionEvent) {
    }
}