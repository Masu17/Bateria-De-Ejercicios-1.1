package com.application.bateriaejerciciosuno.controllers;

import com.application.bateriaejerciciosuno.models.BoletinPublicado;
import com.application.bateriaejerciciosuno.services.Persistence;
import com.application.bateriaejerciciosuno.view.ShowBoletinView;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class showBoletinController {

    public TextArea WritableTextArea;

    public void initialize() {
        Persistence.getPersistenceList().forEach(object -> {
            if (object instanceof BoletinPublicado) {
                WritableTextArea.appendText(((BoletinPublicado) object).toString() + "\n");
            }
        });
    }

    public void closeWindow(ActionEvent actionEvent) {
        ShowBoletinView.getShowStateStage().close();
    }

}
