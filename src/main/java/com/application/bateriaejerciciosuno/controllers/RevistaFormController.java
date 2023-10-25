package com.application.bateriaejerciciosuno.controllers;

import com.application.bateriaejerciciosuno.models.RevistasPublicadas;
import com.application.bateriaejerciciosuno.services.CheckService;
import com.application.bateriaejerciciosuno.services.Persistence;
import com.application.bateriaejerciciosuno.utils.ControllerUtils;
import com.application.bateriaejerciciosuno.view.RevistaFormView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.*;

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


    public void enviarRevistaBttn(ActionEvent actionEvent) {

        HashMap<String, String> controlsMap = ControllerUtils.
                saveDataToMap(Arrays.asList(
                        TituloTextField,
                        AutorTextField,
                        EditorialTextField,
                        EmailTextField,
                        NumPaginasTextField,
                        PrecioTextField,
                        FormatoContainer));

        controlsMap.forEach((key, value) -> System.out.println("id:\n" + key + "\nvalor:\n" + value));

        String fallos = CheckService.checkRevista(controlsMap, "Revista");

        if (!fallos.isEmpty()) {
            JOptionPane panelError = new JOptionPane("Se han producido los siguientes errores:\n" + fallos, JOptionPane.ERROR_MESSAGE);
            JDialog dialog = panelError.createDialog(null, "Error");
            dialog.addWindowFocusListener(new WindowFocusListener() {
                @Override
                public void windowGainedFocus(WindowEvent e) {
                    // No hacer nada cuando el diálogo gana el foco
                }
                @Override
                public void windowLostFocus(WindowEvent e) {
                    dialog.setVisible(false); // Cerrar el diálogo cuando pierde el foco
                }
            });
            dialog.setVisible(true);
        }else {
            Persistence.add(new RevistasPublicadas(
                    controlsMap.get("tittle"),
                    controlsMap.get("formato"),
                    controlsMap.get("email"),
                    controlsMap.get("autor"),
                    controlsMap.get("editorial"),
                    Integer.parseInt(controlsMap.get("numPaginas")),
                    Double.parseDouble(controlsMap.get("precio"))));
            JOptionPane.showMessageDialog(null, "Se ha guardado la revista correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void cerrarVentanaBttn(ActionEvent actionEvent) {
        RevistaFormView.getRevistaFormStage().close();
    }
}
