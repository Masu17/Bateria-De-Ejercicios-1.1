package com.application.bateriaejerciciosuno.controllers;

import com.application.bateriaejerciciosuno.models.RevistasPublicadas;
import com.application.bateriaejerciciosuno.services.Persistence;
import com.application.bateriaejerciciosuno.view.ShowRevistaView;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class showRevistaController {
    public TextArea WritableTextArea;

    public void initialize() {
        Persistence.getPersistenceList().forEach(object -> {
            if (object instanceof RevistasPublicadas) {
                WritableTextArea.appendText(((RevistasPublicadas) object).toString() + "\n");
            }
        });
        WritableTextArea.appendText("\n");
    }

    public void closeWindow(ActionEvent actionEvent) {
        ShowRevistaView.getShowStateStage().close();
    }
}
