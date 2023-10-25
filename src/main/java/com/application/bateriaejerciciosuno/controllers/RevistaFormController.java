package com.application.bateriaejerciciosuno.controllers;

import com.application.bateriaejerciciosuno.models.RevistasPublicadas;
import com.application.bateriaejerciciosuno.services.CheckService;
import com.application.bateriaejerciciosuno.services.Persistence;
import com.application.bateriaejerciciosuno.utils.ControllerUtils;
import com.application.bateriaejerciciosuno.view.RevistaFormView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Arrays;
import java.util.HashMap;

public class RevistaFormController {

    ObservableList<String> revistasList = FXCollections.observableArrayList("Digital", "Impresa");
    @FXML
    public ChoiceBox FormatoContainer;
    @FXML
    public TextField PrecioTextField;
    @FXML
    public TextField NumPaginasTextField;
    @FXML
    public TextField EmailTextField;
    @FXML
    public TextField EditorialTextField;
    @FXML
    public TextField AutorTextField;
    @FXML
    public TextField TituloTextField;

    @SuppressWarnings("unchecked")
    public void initialize() {
        FormatoContainer.getItems().addAll(revistasList);
        FormatoContainer.setValue("Elegir una opción");
    }

    public void enviarRevistaBttn() {

        HashMap<String, String> controlsMap = ControllerUtils.
                saveDataToMap(Arrays.asList(
                        TituloTextField,
                        AutorTextField,
                        EditorialTextField,
                        EmailTextField,
                        NumPaginasTextField,
                        PrecioTextField,
                        FormatoContainer));

        String fallos = CheckService.checkRevista(controlsMap, "Revista");

        if (!fallos.isEmpty()) {
            ControllerUtils.createJOptionPane("Se han producido los siguientes errores:\n" + fallos, "Error", 1);
        } else {
            Persistence.add(new RevistasPublicadas(
                    controlsMap.get("Titulo"),
                    controlsMap.get("Formato"),
                    controlsMap.get("Email"),
                    controlsMap.get("Autor"),
                    controlsMap.get("Editorial"),
                    Integer.parseInt(controlsMap.get("NumPaginas")),
                    Double.parseDouble(controlsMap.get("Precio"))));
            ControllerUtils.createJOptionPane("Se ha añadido la revista correctamente", "Correcto", 1);
        }

    }

    public void cerrarVentanaBttn() {
        RevistaFormView.getRevistaFormStage().close();
    }
}
