package com.application.bateriaejerciciosuno.controllers;

import com.application.bateriaejerciciosuno.view.BoletinFormView;
import com.application.bateriaejerciciosuno.view.RevistaFormView;
import com.application.bateriaejerciciosuno.view.ShowBoletinView;
import com.application.bateriaejerciciosuno.view.ShowRevistaView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    public Label nombre;

    @FXML
    public void openRevistaCreator(ActionEvent actionEvent) {
        RevistaFormView.runRevistaFormView();
    }

    public void openRevistaShow(ActionEvent actionEvent) {
        ShowRevistaView.runRevistaFormView();
    }
    @FXML
    public void openBoletinCreator(ActionEvent actionEvent) {
        BoletinFormView.runBoletinFormView();
    }

    public void openBoletinShow(ActionEvent actionEvent) {
        ShowBoletinView.runRevistaFormView();
    }
}