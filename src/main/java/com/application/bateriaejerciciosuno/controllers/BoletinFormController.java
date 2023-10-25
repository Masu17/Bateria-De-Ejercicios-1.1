package com.application.bateriaejerciciosuno.controllers;

import com.application.bateriaejerciciosuno.models.BoletinPublicado;
import com.application.bateriaejerciciosuno.models.RevistasPublicadas;
import com.application.bateriaejerciciosuno.services.CheckService;
import com.application.bateriaejerciciosuno.services.Persistence;
import com.application.bateriaejerciciosuno.utils.ControllerUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Arrays;
import java.util.HashMap;

public class BoletinFormController {

    public TextField NombreTextField;
    public TextField FechaTextField;
    public TextField NumPaginasTextField;
    public TextField PrecioTextField;

    public void enviarBoletinBttn(ActionEvent actionEvent) {
        HashMap<String, String> controlsMap = ControllerUtils.
                saveDataToMap(Arrays.asList(
                        NombreTextField,
                        FechaTextField,
                        NumPaginasTextField,
                        PrecioTextField));

        String fallos = CheckService.checkRevista(controlsMap, "Boletin");

        if (!fallos.isEmpty()) {
            ControllerUtils.createJOptionPane("Se han producido los siguientes errores:\n" + fallos, "Error", 1);
        } else {
            Persistence.add(new BoletinPublicado(
                    controlsMap.get("Nombre"),
                    controlsMap.get("Fecha"),
                    Integer.parseInt(controlsMap.get("NumPaginas")),
                    Double.parseDouble(controlsMap.get("Precio"))
            ));
            ControllerUtils.createJOptionPane("Se ha añadido la revista correctamente", "Correcto", 1);
        }

    }

    public void cerrarVentanaBoletinBttn(ActionEvent actionEvent) {
    }
}
